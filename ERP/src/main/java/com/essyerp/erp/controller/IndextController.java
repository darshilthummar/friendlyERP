package com.essyerp.erp.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essyerp.erp.model.login.User;
import com.essyerp.erp.repo.logrepo.UserRepository;


@Controller
@RequestMapping("/")
public class IndextController 
{

	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/login")
	public String getLogin()
	{
		return "snippets/pages/user/login-1";
	}
	
	@RequestMapping(value={" ","/", "/index"})
	public String getIndext()
	{
		
		return "index";
	}
	
	
	@RequestMapping("/userdata")
	@ResponseBody
	public User getddata(HttpServletRequest request, Model m)
	{
		Long user = (Long) request.getSession().getAttribute("UserId");

		
		System.out.println(userRepo.findById(user).orElse(null));
		return userRepo.findById(user).orElse(null);
	}
	
}
