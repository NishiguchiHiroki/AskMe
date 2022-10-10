package com.example.AskMe.presentation.controller.security;


import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.AskMe.application.service.security.AccessService;
import com.example.AskMe.domain.model.customer.User;
import com.example.AskMe.domain.model.security.SignUpForm;
import com.example.AskMe.presentation.security.springsecurity.auth.UserRepository;
import com.example.AskMe.presentation.security.springsecurity.auth.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AccessController {
	
	private final AccessService accessService;
	private final UserRepository userRepository;
	private final UserService userService;
	
    @GetMapping("/")
    public String root(@AuthenticationPrincipal OidcUser oidcUser, Model model) {
    	
    	//メールアドレス認証でログインしたユーザ情報を取得
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User loginUserInfo = accessService.getLoginUserInfo(auth, oidcUser);

    	model.addAttribute("loginUser", loginUserInfo);
    	return "access/index";
    }
    
    @GetMapping("/login")
    public String showLoginForm() {
    	return "access/login";
    }
    
    @GetMapping("/signup")
    public String showSignupForm() {
    	return "access/signup";
    }
    
    @PostMapping("/signup")
    public String createSignupForm( @Validated @ModelAttribute SignUpForm signUpForm, BindingResult result, Model model, HttpServletRequest request) {
  
    		Optional<User> registered = userRepository.findByUserEmail(signUpForm.getEmail());
 
    		if(registered.isPresent()) {
    			model.addAttribute("email", "email.duplicated");
                return createValidationErrorResponse();
    		}
    		
    		if(result.hasErrors()) {
    			model.addAttribute("signUpForm", signUpForm);
    			return createValidationErrorResponse();
    		}
    		userService.create(signUpForm.getUsername(), signUpForm.getEmail(), signUpForm.getPassword(), "USER");
    	
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken == false) {
            SecurityContextHolder.clearContext();
        }

        try {
            request.login(signUpForm.getEmail(), signUpForm.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }
    	
    	return "redirect:/";
    }
    
    private String createValidationErrorResponse() {
    	return "access/signup";
    }
}
