package com.example.AskMe.security.auth;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	public User() {}
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
