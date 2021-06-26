package com.pvj.exception;

import static com.pvj.constants.ErrorCodeConstants.ITEM_NOT_FOUND;
import static com.pvj.constants.HTTPStatusCode.NOT_FOUND;

public class ItemNotFoundException extends GlobalResponseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(String logref, String message) {
		super(ITEM_NOT_FOUND, logref, message, NOT_FOUND);
		// TODO Auto-generated constructor stub
	}

}
