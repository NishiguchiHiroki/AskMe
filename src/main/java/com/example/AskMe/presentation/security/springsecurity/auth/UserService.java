package com.example.AskMe.presentation.security.springsecurity.auth;

import java.util.List;

import org.postgresql.util.PGTimestamp;
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
	
	public void create(String username, String email, String password, String authority) {
		var encodePassword = passwordEncoder.encode(password);
		try {	
			Authority auth = Authority.valueOf(authority);
			PGTimestamp nowtime = new PGTimestamp(System.currentTimeMillis());
			userRepository.insert(username, email, encodePassword, auth.name(), nowtime, nowtime);
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("該当する権限はありません。");
		}
	}

}
