package com.org.rating.web.exception;

import org.springframework.http.HttpStatus;

/**
 * {@link HttpStatus#is4xxClientError()}
 * @author Anvi P
 *
 */
public class BusinessValidationException extends EndUserException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3527499391373551071L;

	public BusinessValidationException(String message) {
		super(message);
	}

}
