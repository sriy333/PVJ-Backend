package com.pvj.exception;

import static com.pvj.constants.HTTPStatusCode.BAD_REQUEST;
import static com.pvj.constants.SqlErrorMessages.CONNECTION_EXCEPTION;;

public class SqlDBException extends GlobalResponseException {

	private static final long serialVersionUID = 1L;

	public SqlDBException(final String logref,final String message) {
        super(CONNECTION_EXCEPTION,logref, message, BAD_REQUEST);
    }
}
