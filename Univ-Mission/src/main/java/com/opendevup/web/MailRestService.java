package com.opendevup.web;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opendevup.metier.MailMessageNotification;
import com.opendevup.util.NotificationMessage;



@RestController

public class MailRestService {
	@Autowired
	private MailMessageNotification mail;


	@RequestMapping("/send")
	 public String sendMessage() {
		try {
			mail.sendMail( "ousmanegueye7831@gmail.com", "Test", "Boujour tout le monde");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Mail send";
	}


	

}
