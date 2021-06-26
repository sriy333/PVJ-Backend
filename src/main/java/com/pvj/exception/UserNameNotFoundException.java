package com.pvj.exception;

import static com.pvj.constants.ErrorCodeConstants.USERNAME_NOT_FOUND;
import static com.pvj.constants.HTTPStatusCode.NOT_FOUND;

public class UserNameNotFoundException extends GlobalResponseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameNotFoundException(String logref, String message) {
		super(USERNAME_NOT_FOUND, logref, message, NOT_FOUND);
		// TODO Auto-generated constructor stub
	}

}
