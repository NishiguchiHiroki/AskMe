package com.example.AskMe.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "security/index";
    }
    
    @GetMapping("/login")
    public String showLoginForm() {
    	return "security/login";
    }
    
    @GetMapping("/logout")
    public String showLogoutForm() {
    	return "security/logout";
    }
}
