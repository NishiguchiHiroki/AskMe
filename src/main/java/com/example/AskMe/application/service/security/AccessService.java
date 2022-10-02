package com.example.AskMe.application.service.security;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.example.AskMe.domain.model.customer.User;
import com.example.AskMe.presentation.security.springsecurity.auth.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccessService {
	
	private final UserRepository userRepository;
	
	public User getLoginUserInfo(Authentication auth, @AuthenticationPrincipal OidcUser user) {
		User loginUser = new User();
		
		//DBから取得したユーザ情報を格納する変数
		Optional<User> getUserInfo = Optional.ofNullable(new User());
			if (user != null) {
				getUserInfo = userRepository.findByUserEmail(user.getEmail());
				
			} else if (auth != null) {
				//getNameでログインユーザーのEmailを取得
				String email = auth.getName();
				getUserInfo = userRepository.findByUserEmail(email);
				
			}
			
			loginUser = getUserInfo.get();
			return loginUser;
			
	}

}
