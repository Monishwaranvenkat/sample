package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.ComplaintsDescriptionModel;
import com.service.StudentService;
@Controller
@RequestMapping("/student")

public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	@GetMapping("/filedcomplaint")
	public String student(HttpSession session,Model m,HttpServletResponse response){
		
		String uname=(String) session.getAttribute("uname");
		if(uname==null)
		{
			 return "redirect:/user/login";
		}else{
			
			m.addAttribute("list", studentservice.viewcomplaint(uname));
			return "student";
		}
	}
	@PostMapping("/filedcomplaint")
	public String sortComplaint(HttpSession session,HttpServletRequest rq,Model m){
		
		if(rq.getParameter("sort").equals("all"))
		{
			m.addAttribute("list", studentservice.viewcomplaint((String) session.getAttribute("uname")));
			return "student";
		}else if(rq.getParameter("sort").equals("solved")){
			m.addAttribute("list", studentservice.solvedComplaints((String) session.getAttribute("uname")));
			return "student";
		}else{
			m.addAttribute("list", studentservice.unsolvedComplaints((String) session.getAttribute("uname")));
			return "student";
		}
		
	}
}
