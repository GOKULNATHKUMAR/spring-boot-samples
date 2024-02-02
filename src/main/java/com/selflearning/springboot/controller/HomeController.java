package com.selflearning.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Value("${application.name}")
	private String appName;
	
	@GetMapping("home")
	public String homeCalling() {
		
		return "Home Controller Calling :"+appName;
	}
}
