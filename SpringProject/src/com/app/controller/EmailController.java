package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Email;

@Controller
public class EmailController {

	@Autowired
	MailSender mailSender;

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public ModelAndView sendMail() {
		return new ModelAndView("sendmail");
	}

	@RequestMapping(value = "/sent", method = RequestMethod.POST)
	public String sendEmail(@ModelAttribute("emailForm") Email email) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email.getTo());
		mail.setSubject(email.getSubject());
		mail.setText(email.getMessage());
		mailSender.send(mail);
		return "redirect:/welcome";
	}
}
