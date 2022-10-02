package com.example.AskMe.presentation.controller.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.AskMe.application.service.security.AccessService;
import com.example.AskMe.domain.model.customer.User;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AccessController {
	
	private final AccessService accessService;
	
    @GetMapping("/")
    public String root(@AuthenticationPrincipal OidcUser oidcUser, Model model) {
    	
    	User loginUserInfo = new User();
    	
    	//メールアドレス認証でログインしたユーザ情報を取得
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	loginUserInfo = accessService.getLoginUserInfo(auth, oidcUser);

    	model.addAttribute("loginUser", loginUserInfo);
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
