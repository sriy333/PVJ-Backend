package com.pvj.exception;

import static com.pvj.constants.ErrorCodeConstants.INVALID_USERNAME_CODE;
import static com.pvj.constants.HTTPStatusCode.BAD_REQUEST;

public class InvalidUserNameException extends GlobalResponseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUserNameException(String logref, String message) {
		super(INVALID_USERNAME_CODE,logref, message, BAD_REQUEST);
	}

	
}
