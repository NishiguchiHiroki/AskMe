package com.example.AskMe.security.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.AskMe.security.auth.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{

	private final UserRepository userRepository;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO 自動生成されたメソッド・スタブ
		return userRepository.findByUserEmail(value).isEmpty();
	}
	
	

}
