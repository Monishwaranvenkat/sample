package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LogoutController {
	@GetMapping("/logout")
	public String student(HttpSession session,HttpServletRequest rq,HttpServletResponse response){
		session.invalidate();
		return "/";
	}
}
