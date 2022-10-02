package com.example.AskMe.domain.model.customer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	public User() {}
	
	private int id;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@Email
	private String email;
	
	private int enabled;

	private Authority authority;
	
	@NotBlank
	public enum Authority {
		ADMIN,
		USER;
	}
}
