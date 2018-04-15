package com.hh.reidbuilds.services;

import com.hh.reidbuilds.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * Created by cennis on 4/7/18.
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender sender;

    public void sendEmail(ContactForm contactForm) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo("reid@reidbuilds.com");
        helper.setText(contactForm.getMessage());
        helper.setSubject("reidbuilds message from " + contactForm.getName());

        sender.send(message);
    }
}
