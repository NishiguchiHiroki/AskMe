package com.example.AskMe.domain.model.security;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.AskMe.presentation.interceptor.validation.UniqueUsername;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpForm {
	
	public SignUpForm() {}

	@NotBlank(message = "名前を入力してください。")
	@UniqueUsername
	private String username;
	
	@NotBlank(message = "メールアドレスを入力してください。")
	@Email(message = "@を付けたアドレスを入力してください。")
	private String email;
	
	@NotBlank(message = "12桁〜128桁までのパスワードを入力してください。")
	@Size(min=12, max = 128)
	private String password;
	
	private String authority;

	
}
