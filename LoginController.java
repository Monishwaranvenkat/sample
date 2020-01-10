package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.model.LoginValidate;
import com.service.LoginService;

@Controller
@RequestMapping("/user")
@SessionAttributes("uname")
public class LoginController {
@GetMapping("/login")
public String login(){
	return "loginform";
}

@Autowired
private LoginService Loginservice;
@PostMapping("/login")
public String validate(Model model,HttpServletRequest rq,HttpServletResponse rs)
{
	String u=rq.getParameter("uname");
	String p=rq.getParameter("pss");
	LoginValidate lv=new LoginValidate();
	lv.setUsername(u);
	lv.setPassword(p);
 if(Loginservice.check(lv))
 {
	 model.addAttribute("uname",u);
	 return "redirect:/student/filedcomplaint";
 }else
 {
	 return "redirect:login";
 }
}
}
