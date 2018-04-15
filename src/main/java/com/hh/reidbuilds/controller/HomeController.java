package com.hh.reidbuilds.controller;

import com.hh.reidbuilds.model.ContactForm;
import com.hh.reidbuilds.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private EmailService emailService;

    @ModelAttribute
    public ContactForm contactForm() {
        return new ContactForm();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String getMessage(@Valid ContactForm contactForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        try {

            emailService.sendEmail(contactForm);
        } catch (Exception e){

        }
        return "response";
    }
}
