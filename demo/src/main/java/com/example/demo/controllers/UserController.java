package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.service.EmailService;

@Controller
public class UserController {
	
	
	public EmailService emailService;
	
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}


}
