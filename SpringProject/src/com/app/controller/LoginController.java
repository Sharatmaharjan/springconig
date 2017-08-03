package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.UserDao;
import com.app.model.User;
import com.app.servicelayer.UserService;

@Controller
public class LoginController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(){
		System.out.println("hy");
		return new ModelAndView("index");
	}
	@Autowired
	UserService userservice;
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("loginpage") User user){
//		String name=reqPar.get("username");
//		String password=reqPar.get("password");
		System.out.println("hy");
		User user1=userservice.login(user);
		if(user1.getUsername()!=null){
//		ModelAndView model=new ModelAndView("welcome");
//		model.addObject("success msg","Welcome "+user.getUsername());
			return new ModelAndView("welcome");
		}
		else{
//			ModelAndView model=new ModelAndView("index");
//			model.addObject("fail msg","Please enter valid username and password.");
			return new ModelAndView("index");
		}
		
	}
}
