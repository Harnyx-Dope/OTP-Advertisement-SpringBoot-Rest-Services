package com.example.mail;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller 
{
	
	 

	@RestController
	public class EmailController {

	    private final  Service1 emailService;

	    public EmailController(Service1 emailService) {
	        this.emailService = emailService;
	    }

	    @PostMapping("/send-email")
	    public void sendEmail(@RequestBody EmailRequest emailRequest) {
	        emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
	    }
	}

	
}
