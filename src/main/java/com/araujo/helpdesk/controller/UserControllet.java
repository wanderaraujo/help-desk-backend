package com.araujo.helpdesk.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.araujo.helpdesk.entity.User;
import com.araujo.helpdesk.service.UserService;
import com.araujo.helpdesk.util.Response;
import com.mongodb.DuplicateKeyException;

@RestController
@RequestMapping("/api/user")
public class UserControllet {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<User>> create(HttpServletRequest request, @RequestBody User user, BindingResult result){
		Response<User> response = new Response<User>();
		
		try {
			validateCreateUser(user, result);
			if(result.hasErrors()) {
				result.getAllErrors().forEach(err -> response.getErros().add(err.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			User userPersisted = (User) userService.createOrUpdate(user);
			response.setData(userPersisted);
		}catch(DuplicateKeyException e) {
			response.getErros().add("User already redgistred!");
			return ResponseEntity.badRequest().body(response); 
		}catch(Exception e) {
			response.getErros().add(e.getMessage());
			return ResponseEntity.badRequest().body(response); 
		}
		
		return ResponseEntity.ok(response);
	}
	
	public void validateCreateUser(User user, BindingResult result) {
		if(StringUtils.isBlank(user.getEmail())) {
			result.addError(new ObjectError("User", "Not found email."));
		}
	}
}
