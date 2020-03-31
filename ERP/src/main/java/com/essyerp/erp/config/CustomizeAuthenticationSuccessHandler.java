package com.essyerp.erp.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.essyerp.erp.model.login.User;
import com.essyerp.erp.repo.logrepo.UserRepository;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		response.setStatus(HttpServletResponse.SC_OK);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User userFrontVo = userRepository.findUser(auth.getName());
		HttpSession session = request.getSession(false);

		if (session != null)
		{
		session.setAttribute("UserId", userFrontVo.getId());	
		session.setAttribute("UserName", userFrontVo.getUsername());
		session.setAttribute("Email", userFrontVo.getEmail());
		}
		
		
		response.sendRedirect("/index");
		

	}

}

