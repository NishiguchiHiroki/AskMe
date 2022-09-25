package com.example.AskMe.security.auth;

import java.util.Collections;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		return userRepository.findByUserEmail(email)
			.map(
					user -> new CustomUserDetails(
							user.getEmail(),
							user.getPassword(),
							toGrantedAuthorityList(user.getAuthority())
					)
			)
			
			.orElseThrow(
					() -> new UsernameNotFoundException(
							"Given username is not found. (email" + email + ")"
					)
			);
	}

	private List<GrantedAuthority> toGrantedAuthorityList(User.Authority authority) {
		return Collections.singletonList(new SimpleGrantedAuthority(authority.name()));
	}
}