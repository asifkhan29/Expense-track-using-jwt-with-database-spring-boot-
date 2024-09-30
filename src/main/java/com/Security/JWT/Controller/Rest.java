package com.Security.JWT.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {
	
	@GetMapping
	public String str()
	{
		return "hello";
	}

}
