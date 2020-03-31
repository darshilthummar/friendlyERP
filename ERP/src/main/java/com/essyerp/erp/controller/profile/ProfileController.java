package com.essyerp.erp.controller.profile;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.essyerp.erp.repo.logrepo.UserRepository;



@Controller
@RequestMapping("/")
public class ProfileController
{

	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/profile")
	public String getProfile(HttpServletRequest request, Model m)
	{
		System.out.println("======================");
		System.out.println(request.getSession().getAttribute("UserId"));
		System.out.println(request.getSession().getAttribute("UserName"));
		
		Long user = (Long) request.getSession().getAttribute("UserId");
		System.out.println(user);
		
		System.out.println("======================");
		
		m.addAttribute("user", userRepo.findById(user).orElse(null));
		return "profile";
		
	}
	
	
	@RequestMapping("/profile/edit/{id}")
	public String getEditProfile( @PathVariable long id ,Model m)
	{
		
		m.addAttribute("user", userRepo.findById(id).orElse(null));
		return "editprofile";
	}
}
