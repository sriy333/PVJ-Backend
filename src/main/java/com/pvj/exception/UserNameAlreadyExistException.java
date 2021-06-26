package com.pvj.exception;

import static com.pvj.constants.HTTPStatusCode.BAD_REQUEST;
import static com.pvj.constants.ErrorCodeConstants.BAD_REQUEST_CODE;

public class UserNameAlreadyExistException extends GlobalResponseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameAlreadyExistException(String logref, String message) {
		super(BAD_REQUEST_CODE, logref, message, BAD_REQUEST);
	}

}
