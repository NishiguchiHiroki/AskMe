package com.example.AskMe.presentation.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.AskMe.domain.model.customer.User;
import com.example.AskMe.presentation.security.springsecurity.auth.UserRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class customerController {
	
private final UserRepository userRepository;
	
	@GetMapping("/mypage/{id}")
	public String showMyPage(@PathVariable int id, Model model ) {
		
		try {
			User user = userRepository.findByUserId(id);
			model.addAttribute("user", user);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return "customer/mypage";
	}

}
