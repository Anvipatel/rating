package com.org.rating.web.exception;

/**
 * All user's end specific exception should extends given class.
 * @author Anvi P
 *
 */
public abstract class EndUserException extends RuntimeException {

	public EndUserException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -828094340952560913L;

}
