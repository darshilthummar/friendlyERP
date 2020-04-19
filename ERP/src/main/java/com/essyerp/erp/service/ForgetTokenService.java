package com.essyerp.erp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.essyerp.erp.model.login.ForgetToken;
import com.essyerp.erp.model.login.User;
import com.essyerp.erp.model.login.VerificationToken;
import com.essyerp.erp.repo.logrepo.FrogetTokenRepo;
import com.essyerp.erp.repo.logrepo.UserRepository;
import com.essyerp.erp.repo.logrepo.VerificationTokenRepository;

@Service
public class ForgetTokenService 
{


	    private UserRepository userRepository;
	    private FrogetTokenRepo forgetTokenRepo;
	    private SendingMailService sendingMailService;

	    @Autowired
	    public ForgetTokenService(UserRepository userRepository, VerificationTokenRepository verificationTokenRepository, SendingMailService sendingMailService, FrogetTokenRepo forgetTokenRepo){
	        this.userRepository = userRepository;
	        this.forgetTokenRepo = forgetTokenRepo;
	        this.sendingMailService = sendingMailService;
	    }
	    
	    public void createForget(String email){
	    	 List<User> users = userRepository.findByEmail(email);
	         User user;
	         if (users.isEmpty()) {
	             user = new User();
	             user.setEmail(email);
	             userRepository.save(user);
	         } else {
	             user = users.get(0);
	         }
	    List<ForgetToken> forgetTokens = forgetTokenRepo.findByUserEmail(email);
        ForgetToken forgetToken;
        if (forgetTokens.isEmpty()) {
            forgetToken = new ForgetToken();
            forgetToken.setUser(user);
            forgetTokenRepo.save(forgetToken);
        } else {
            forgetToken = forgetTokens.get(0);
            forgetToken.setToken(UUID.randomUUID().toString());
            forgetToken.setStatus("PENDING");
            forgetToken.setIssuedDateTime(LocalDateTime.now());
            forgetToken.setExpiredDateTime(LocalDateTime.now().plusMinutes(30));
            forgetToken.setConfirmedDateTime(null);
            forgetTokenRepo.save(forgetToken);
        }
	    
        sendingMailService.sendForgetMail(email, forgetToken.getToken());
	    }

	    public String verifyEmail(String token,HttpServletRequest request){
	    	
	    	HttpSession session = request.getSession(false);

	        List<ForgetToken> forgetTokens = forgetTokenRepo.findByToken(token);
	        if (forgetTokens.isEmpty()) {
	            return "/404";
	        }

	        ForgetToken forgetToken = forgetTokens.get(0);
	        if (forgetToken.getExpiredDateTime().isBefore(LocalDateTime.now())) {
	            return "/500";
	        }

	        if ((forgetToken.getStatus()).equalsIgnoreCase("VERIFIED")) {
	            return "/500";
	        }
	        
	        forgetToken.setConfirmedDateTime(LocalDateTime.now());
	        forgetToken.setStatus(VerificationToken.STATUS_VERIFIED);
	        session.setAttribute("userID",forgetToken.getUser().getId());
//	        System.out.println("===========================");
//	        System.out.println(forgetToken.getUser().getId());
//	       
//	        System.out.println(request.getSession().getAttribute("userID"));
//	        System.out.println("===========================");
	        forgetTokenRepo.save(forgetToken);
	        return "forget";
	    }

}
