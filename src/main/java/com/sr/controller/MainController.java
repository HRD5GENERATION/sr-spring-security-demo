package com.sr.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin(){
		return "admin/admin";
	}
	
	@GetMapping("/dba")
	public String dba(){
		return "dba/dba";
	}
	
	@GetMapping("/user")
	public String user(){
		return "user/user";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	public static void main(String[] args) {		
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		String encoded = bc.encode("123");
		System.out.println(encoded);
		
	}
}
