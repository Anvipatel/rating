package com.org.revrep.backend.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.org.revrep.web.exception.BusinessValidationException;
import com.org.revrep.web.view.registration.SignUpInfo;

@Service
public class SignUpService {

	public SignUpInfo addNewUser(SignUpInfo signUpInfo) {
		if(Objects.isNull(signUpInfo)) {
			throw new BusinessValidationException("Error");
		}
		return signUpInfo;
	}

}
