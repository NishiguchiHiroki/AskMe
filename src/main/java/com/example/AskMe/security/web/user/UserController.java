package com.example.AskMe.security.web.user;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.AskMe.security.auth.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping
	public String showList(Model model) {
		var x = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("userList", userService.findAll());
		return "users/list";
	}
	
	//Get  /user/creationForm
	@GetMapping("/creationForm")
	public String showCreationForm(@ModelAttribute UserForm form) {
		form.setAuthority("ADMIN");
		return "users/creationForm";
	}
	
	@PostMapping
	public String create(@Validated UserForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return showCreationForm(form);
		}
		
		userService.create(form.getUsername(), form.getEmail(), form.getPassword(), form.getAuthority() );
		return "redirect:/users";
	}

}
