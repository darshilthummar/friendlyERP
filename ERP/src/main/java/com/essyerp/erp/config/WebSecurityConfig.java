package com.essyerp.erp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler; 
	
	@Autowired
	CustomLoginFailureHandler customLoginFailureHandler;
	
	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordencoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());

	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/location/**", "/assets/**", "/image/**", "/img/**","/css/**","/images/**","/fonts/**", "/public/**",
				"/resources/public/**", "/resources/**", "/swagger-resources/**", "/registration/**","/friendlyERP/**","/email")
				.permitAll()
				.antMatchers("/login").permitAll()
//				.antMatchers("/index").access("hasRole('ROLE_ADMIN')")
				.anyRequest().authenticated().and().formLogin().loginPage("/login")
				.successHandler(customizeAuthenticationSuccessHandler).usernameParameter("username")
				.failureHandler(customLoginFailureHandler)
				.passwordParameter("password")
				.and().logout()
				.logoutSuccessUrl("/login?logout").deleteCookies("auth_code", "JSESSIONID").invalidateHttpSession(true).and().exceptionHandling()
				.accessDeniedPage("/403").and().csrf().disable();
		http.headers().frameOptions().sameOrigin();
		http.sessionManagement().invalidSessionUrl("/login").maximumSessions(100).maxSessionsPreventsLogin(true);
		http.sessionManagement().sessionFixation().migrateSession()
		.sessionAuthenticationStrategy(registerSessionAuthStr());
	}

	private SessionAuthenticationStrategy registerSessionAuthStr() {
		// TODO Auto-generated method stub
		return null;
	}
}
