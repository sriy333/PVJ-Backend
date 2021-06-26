package com.pvj.exception;

import static com.pvj.constants.ErrorMessages.JSON_ERROR_MESSAGE;
import static com.pvj.constants.HTTPStatusCode.INTERNAL_SERVER_ERROR;


public class JsonExtractionException extends GlobalResponseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JsonExtractionException(String logref, String message) {
		super(JSON_ERROR_MESSAGE, logref, message, INTERNAL_SERVER_ERROR);
		// TODO Auto-generated constructor stub
	}

}
