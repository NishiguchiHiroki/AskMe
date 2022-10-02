package com.example.AskMe.presentation.security.springsecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http	
				.authorizeRequests()
//				.mvcMatchers("/**").permitAll()
				.mvcMatchers("/login/**").permitAll()
				.mvcMatchers("/signup/**").permitAll()
				.antMatchers("/css/**","/js/**","/image/**").permitAll()
				.mvcMatchers("/users/**").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and()
		        .oauth2Login()
		        .loginPage("/login").permitAll()
		        .and()
		        .formLogin()
		        .loginPage("/login").permitAll()
		        .usernameParameter("email")
		        .passwordParameter("password");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
	        .passwordEncoder(passwordEncoder);
	}
}
