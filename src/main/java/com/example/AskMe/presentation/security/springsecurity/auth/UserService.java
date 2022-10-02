package com.example.AskMe.presentation.security.springsecurity.auth;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.AskMe.domain.model.customer.User;
import com.example.AskMe.domain.model.customer.User.Authority;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	public void create(String username, String email, String password, String authority) {
		var encodePassword = passwordEncoder.encode(password);
		try {	
			Authority auth = Authority.valueOf(authority);
			userRepository.insert(username, email, encodePassword, auth.name());
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("該当する権限はありません。");
		}
	}

}
