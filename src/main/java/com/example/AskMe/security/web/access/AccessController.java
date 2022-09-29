package com.example.AskMe.security.web.access;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.AskMe.security.auth.User;
import com.example.AskMe.security.auth.UserRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AccessController {
	
	private final UserRepository userRepository;
	
    @GetMapping("/")
    public String root(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String loginUserEmail = auth.getName();
    	Optional<User> loginUser = userRepository.findByUserEmail(loginUserEmail);

    	if(loginUser.isPresent()) {
    		model.addAttribute("loginUser", loginUser.get());
    		return "web/root/root";
    		
	    }
    	
    		return "web/root/root";
    	
        
    }
    
    @GetMapping("/login")
    public String showLoginForm() {
    	return "access/login";
    }
    
    @GetMapping("/logout")
    public String showLogoutForm() {
    	return "access/logout";
    }
}
