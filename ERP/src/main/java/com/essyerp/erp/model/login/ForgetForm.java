package com.essyerp.erp.model.login;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class ForgetForm 
{

	 @NotEmpty
	    @Email
	    private String email;

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }
}
