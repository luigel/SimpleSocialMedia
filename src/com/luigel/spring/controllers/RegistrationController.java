package com.luigel.spring.controllers;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luigel.spring.dao.User;
import com.luigel.spring.service.UsersService;

@Controller
public class RegistrationController {

	@Autowired
	private UsersService usersService;

	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String createAccount(@Validated User user, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			System.out.println("Has errors");
			model.addAttribute("errors", "1");
			return "index";
		}

		user.setAuthority("ROLE_USER");
		user.setDateCreated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		System.out.println(user);

		if (usersService.exists(user.getUsername())) {
			System.out.println("Caught Duplicate username");
			result.rejectValue("username", "DuplicateKey.user.username");
			model.addAttribute("errors", "2");
			return "index";
		}

		try {
			usersService.create(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.user.username");
			model.addAttribute("errors", "2");
			return "index";
		}
		
		model.addAttribute("errors", "0");
		model.addAttribute("user", new User());
		return "index";
	}

	public String getVerificationCode() {
		return new BigInteger(130, new SecureRandom()).toString(32);
	}
}
