package com.controller;
import java.util.*;
import com.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
@RequestMapping("/")
public String home(){
	return "index";
}
}
