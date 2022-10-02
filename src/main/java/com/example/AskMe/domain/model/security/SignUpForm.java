package com.example.AskMe.domain.model.security;

import java.security.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.AskMe.presentation.interceptor.validation.UniqueUsername;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpForm {
	
	@NotBlank
	@UniqueUsername
	private String username;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(min=12, max = 128)
	private String password;
	
	private String authority;

}
