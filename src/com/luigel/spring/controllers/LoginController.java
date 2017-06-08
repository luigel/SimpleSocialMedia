package com.luigel.spring.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luigel.spring.dao.User;
import com.luigel.spring.service.UsersService;

@Controller
public class LoginController {
	
	private UsersService usersService;
	
	@RequestMapping("/login")
	public String showLogin() {
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			String cookieName = "remember-me";
			Cookie cookie = new Cookie(cookieName, null);
			cookie.setMaxAge(0);
			cookie.setPath(StringUtils.hasLength(request.getContextPath()) ? request.getContextPath() : "/");
			response.addCookie(cookie);
		}

		return "index";// You can redirect wherever you want, but generally
		// it's a good practice to show login screen again.
	}
	
//	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
//	public String createAccount(User user, BindingResult result) {
//
//		if (result.hasErrors()) {
//			return "newaccount";
//		}
//
//		user.setAuthority("ROLE_USER");
//		user.setEnabled(true);
//
//		if (usersService.exists(user.getUsername())) {
//			System.out.println("Caught Duplicate username");
//			result.rejectValue("username", "DuplicateKey.user.username");
//			return "newaccount";
//		}
//
//		try {
//			usersService.create(user);
//		} catch (DuplicateKeyException e) {
//			result.rejectValue("username", "DuplicateKey.user.username");
//			return "newaccount";
//		}
//
//		return "accountcreated";
//	}
}
