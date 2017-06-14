package com.luigel.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luigel.spring.dao.User;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String showIndex(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}
	
	@RequestMapping("/home")
	public String showHome() {
		return "home";
	}
	
}
