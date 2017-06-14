package com.luigel.spring.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luigel.spring.dao.User;

@Controller
public class LoginController {
	
	@Autowired
	ApplicationEventPublisher eventPublisher;

	@RequestMapping("/login")
	public String showLogin() {
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			String cookieName = "remember-me";
			Cookie cookie = new Cookie(cookieName, null);
			cookie.setMaxAge(0);
			cookie.setPath(StringUtils.hasLength(request.getContextPath()) ? request.getContextPath() : "/");
			response.addCookie(cookie);
		}
		
		model.addAttribute("user", new User());
		
		return "index";// You can redirect wherever you want, but generally
		// it's a good practice to show login screen again.
	}
	
	@RequestMapping("/login/error")
	public String showErrorLogin(Model model) {
		model.addAttribute("user", new User());
		return "loginError";
	}
	
//	@RequestMapping(value = "/login/error/{error}", method = RequestMethod.GET)
//	public final String displayLoginform(Model model,  @PathVariable final String error) {
//	    model.addAttribute("error", error);
//	    return "loginError";
//	}
	
}
