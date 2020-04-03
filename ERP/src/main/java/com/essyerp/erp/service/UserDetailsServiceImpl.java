package com.essyerp.erp.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.essyerp.erp.model.login.Role;
import com.essyerp.erp.model.login.User;
import com.essyerp.erp.repo.logrepo.UserRepository;



@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService 
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		
		User user=userRepository.findUser(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	       
	        if (user.getVerificationToken().getExpiredDateTime().isBefore(LocalDateTime.now())) {
	        	user.setIsActive(null);
	        	return null;
	        }
		
		for (Role role : user.getRoles())
		{
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	    }

			
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}

}
