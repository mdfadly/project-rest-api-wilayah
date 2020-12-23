package com.quiz.projectWilayah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")

//cross origin digunakan untuk menyambungkan dengan front end diluar java spring boot
//@CrossOrigin(origins = "localhost:3000")
public class WebController {
	
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
}
