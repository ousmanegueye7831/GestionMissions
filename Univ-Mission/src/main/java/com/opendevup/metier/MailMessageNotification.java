package com.opendevup.metier;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailMessageNotification {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail( String to, String subject, String msg) throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
	
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(msg);
		mailSender.send(message);	
	}
}
