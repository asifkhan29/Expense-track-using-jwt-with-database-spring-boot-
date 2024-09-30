package com.Security.JWT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Security.JWT.Service.RegistrationService;
import com.Security.JWT.model.RegistrationRequest;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class RegistartionController {
	
	 @Autowired
	    private RegistrationService registrationService;

	    @PostMapping("/register")
	    public String register(@RequestBody RegistrationRequest request) {
	        try {
	            registrationService.registerUser(request);
	            return "User registered successfully!";
	        } catch (IllegalArgumentException e) {
	            return e.getMessage();
	        }
	    }

}
