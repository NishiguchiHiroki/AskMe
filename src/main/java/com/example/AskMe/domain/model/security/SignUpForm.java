package com.example.AskMe.domain.model.security;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpForm {
	
	public SignUpForm() {}

	@NotBlank(message = "名前を入力してください。")
	private String username;
	
	@NotBlank(message = "メールアドレスを入力してください。")
	@Email(message = "@を付けたアドレスを入力してください。")
	private String email;
	
	@NotBlank(message = "4桁〜128桁までのパスワードを入力してください。")
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	@Length(min=4, max = 128)
	private String password;
	
	private String authority;

	
}
