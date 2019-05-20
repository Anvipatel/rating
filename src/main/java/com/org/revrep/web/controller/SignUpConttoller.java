package com.org.revrep.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.revrep.backend.service.SignUpService;
import com.org.revrep.web.view.registration.SignUpInfo;

/**
 * @author Anvi P
 *
 */
@RestController
@RequestMapping("/signup")
public class SignUpConttoller {

	@Autowired
	private SignUpService signUpService;
	
	
	@PostMapping
	public ResponseEntity<SignUpInfo> signUpUser(@RequestBody @Validated SignUpInfo signUpInfo) {
		
		return ResponseEntity.ok(signUpService.addNewUser(signUpInfo));
	}
}
