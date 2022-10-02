package com.example.AskMe.domain.model.customer;

import java.util.Optional;
import javax.validation.constraints.NotBlank;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import com.example.AskMe.presentation.security.springsecurity.auth.UserRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class User {
	
	public User() {}
	
	private int id;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	private String email;
	
	private int enabled;

	private Authority authority;
	
	@NotBlank
	public enum Authority {
		ADMIN,
		USER;
	}
}
