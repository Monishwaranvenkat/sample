package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.RegisterModel;
import com.model.RegisterProcessModel;
import com.service.RegisterService;

@Controller
@RequestMapping("/user")

public class RegisterController {
	@Autowired
	private RegisterService rs;
@GetMapping("/register")
public String register(Model mv)
{
	RegisterModel r= rs.getAssets();
	 List<String> gender=new ArrayList<String>(r.getGender());
	 System.out.print(gender);
	 List<String> college=new ArrayList<String>(r.getCollege());
	mv.addAttribute("gender", gender);
	mv.addAttribute("college", college);
	return "registerform";
}
@PostMapping("/register")
public String Processing(HttpServletRequest rq){
	RegisterProcessModel rm=new RegisterProcessModel();
	rm.setName(rq.getParameter("name"));
	rm.setEmail(rq.getParameter("email"));
	rm.setPhone(rq.getParameter("phno"));
	rm.setDob(rq.getParameter("dob"));
	rm.setGender(rq.getParameter("gender"));
	rm.setRegno(rq.getParameter("regno"));
	rm.setCollege(rq.getParameter("collage"));
	if(rs.process(rm))
	{
		return "redirect:/";
	}else{
		return "redirect:register";
	}
}
	
}
