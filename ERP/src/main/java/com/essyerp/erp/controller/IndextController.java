package com.essyerp.erp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IndextController 
{

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
	
	@RequestMapping("/profile")
	public String getProfile()
	{
		return "profile";
	}
	
}
