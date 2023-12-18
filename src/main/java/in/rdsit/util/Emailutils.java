package in.rdsit.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class Emailutils {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendMail(String to,String subject,String body,File f) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);

	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(body);
	        helper.addAttachment("Plan-info",f);
	        mailSender.send(message);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
