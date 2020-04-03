package com.essyerp.erp.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essyerp.erp.model.login.User;
import com.essyerp.erp.model.login.VerificationForm;
import com.essyerp.erp.repo.logrepo.UserRepository;
import com.essyerp.erp.service.VerificationTokenService;


@Controller
@RequestMapping("/")
public class LogController 
{
	@Autowired
	UserRepository userrepo;
	
	 @Autowired
	 VerificationTokenService verificationTokenService;


	@PostMapping("/registration")
    public String registration(@ModelAttribute User user,@Valid VerificationForm verificationForm) 
	{
     
		String pss=user.getPassword();
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		user.setPassword(pe.encode(pss));
       userrepo.save(user);
       verificationTokenService.createVerification(verificationForm.getEmail());

        return "redirect:/index";
    }
	
	@GetMapping("/friendlyERP/verify-email")
	    @ResponseBody
	    public String verifyEmail(String code) {
	        return verificationTokenService.verifyEmail(code).getBody();
	    }
	
	
	
	
}


