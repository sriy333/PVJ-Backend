package com.pvj.exception;

import static com.pvj.constants.SqlErrorMessages.GLOBAL_ERROR_CODE_PREFIX;


public class GlobalResponseException extends Exception {

	private static final long serialVersionUID = 1L;
    private final String code;
    private final String logref;
    private final String message;
    private final int httpStatus;
    
    public GlobalResponseException(String code, String logref, String message, int httpStatus) {
        super();
        this.code = GLOBAL_ERROR_CODE_PREFIX + code;
        this.logref = logref;
        this.message = message;
        this.httpStatus = httpStatus;
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCode() {
		return code;
	}

	public String getLogref() {
		return logref;
	}

	public String getMessage() {
		return message;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + httpStatus;
		result = prime * result + ((logref == null) ? 0 : logref.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GlobalResponseException other = (GlobalResponseException) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (httpStatus != other.httpStatus)
			return false;
		if (logref == null) {
			if (other.logref != null)
				return false;
		} else if (!logref.equals(other.logref))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GlobalResponseException [code=" + code + ", logref=" + logref + ", message=" + message + ", httpStatus="
				+ httpStatus + "]";
	}
    
    
}
