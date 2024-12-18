package com.essyerp.erp.controller.profile;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essyerp.erp.model.login.User;
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
		Long user = (Long) request.getSession().getAttribute("UserId");
		m.addAttribute("user", userRepo.findById(user).orElse(null));
		return "profile";
		
	}
	
	
	@RequestMapping("/profile/edit/{id}")
	public String getEditProfile( @PathVariable long id ,Model m)
	{
		
		m.addAttribute("user", userRepo.findById(id).orElse(null));
		return "editprofile";
	}
	
	@PostMapping("/profile/update")
	public String setProfile(@ModelAttribute User user, HttpServletRequest request)
	{	
		String username = (String) request.getSession().getAttribute("UserName");
		String email = (String) request.getSession().getAttribute("Email");
		String pass = (String) request.getSession().getAttribute("Password");
		Boolean active = (Boolean) request.getSession().getAttribute("Active");
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(pass);
		user.setIsActive(active);
		user.setImg("User.jpeg");
		userRepo.save(user);
		return "redirect:/profile";
	}
	
	@PostMapping("/save")
	@ResponseBody
	public String getPass(@ModelAttribute User u)
	{
		String pss=u.getPassword();
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		String password = pe.encode(pss);
		System.out.println(u.getId());
		long id1 = u.getId();
		userRepo.changePass(password, id1);
		return "done";

		
		
	}
}
