package com.pvj.exception;

import static com.pvj.constants.ErrorCodeConstants.BAD_REQUEST_CODE;
import static com.pvj.constants.HTTPStatusCode.BAD_REQUEST;

public class BadRequestException extends GlobalResponseException {

	private static final long serialVersionUID = 1L;

	public BadRequestException(String logref, String message) {
		super(BAD_REQUEST_CODE,logref, message, BAD_REQUEST);
		
	}

}
