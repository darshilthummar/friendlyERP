package com.essyerp.erp.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.essyerp.erp.model.login.User;
import com.essyerp.erp.repo.logrepo.UserRepository;

@Component
public class CustomLoginFailureHandler implements AuthenticationFailureHandler {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub

		String message = "";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String username=(String) request.getParameter("userName");
		String password=(String) request.getParameter("password");
		
		User user = userRepository.findByUsername(username);
		
		boolean result =false;

		if (user!=null)
		{
		result = passwordEncoder.matches(password, user.getPassword());

		if(user.getState().equals("PENDING"))
		{
		message="Your Trial is Expaired";
		}else if(result==false)
		{
		message="Password is wrong";
		}
		}else {
		message="Invalid User Name or Password";
		}
		
		System.out.println("-----"+request.getParameter("userName"));
		response.sendRedirect(String.format("/login?error=%s", message));
		
		
	}

}
