package com.essyerp.erp.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essyerp.erp.model.login.ForgetForm;
import com.essyerp.erp.model.login.ForgetToken;
import com.essyerp.erp.model.login.User;
import com.essyerp.erp.model.login.VerificationForm;
import com.essyerp.erp.repo.logrepo.FrogetTokenRepo;
import com.essyerp.erp.repo.logrepo.UserRepository;
import com.essyerp.erp.service.ForgetTokenService;
import com.essyerp.erp.service.SendingMailService;
import com.essyerp.erp.service.VerificationTokenService;


@Controller
@RequestMapping("/")
public class LogController 
{
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	SendingMailService sendingMailService;
	
	 @Autowired
	 VerificationTokenService verificationTokenService;

	 @Autowired
	 ForgetTokenService forgetTokenService;

	 @Autowired
	 FrogetTokenRepo forgetRepo;
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
	
	@PostMapping("/forgetpassword")
	@ResponseBody
	public String forgetPassward(@RequestParam("email") String email, @Valid ForgetForm forgetForm)
	{
		
		System.out.println("forgot password post method page shown"+email);
		forgetTokenService.createForget(forgetForm.getEmail());
		return "done";
	}
	
	@GetMapping("/friendlyERP/reset-email")
  
    public String forgetEmail(String code,HttpServletRequest request) {
        
		
		return	forgetTokenService.verifyEmail(code,request);
			
    }
	
	@PostMapping("/forgetpass")
	
	public String setPass(@RequestParam("password") String password, HttpServletRequest request)
	{
		Long id = (Long) request.getSession().getAttribute("userID");
		//String pss=user.getPassword();
		
		System.out.println("======================");
		System.out.println("FORGET PASSWORD");

		System.out.println(id);
		System.out.println(password);

		System.out.println("======================");
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		String password1 = pe.encode(password);
		userrepo.changePass(password1, id);
		
		return "redirect:/login";
		
	}
	
	
}


