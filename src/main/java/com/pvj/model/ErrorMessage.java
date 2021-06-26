package com.pvj.model;

import com.pvj.exception.GlobalResponseException;

public class ErrorMessage {

    private final String code;
    private final String logref;
    private final String message;

    public ErrorMessage(GlobalResponseException ex) {
        this.message = ex.getMessage();
        this.code = ex.getCode();
        this.logref = ex.getLogref();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		ErrorMessage other = (ErrorMessage) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
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
		return "ErrorMessage [code=" + code + ", logref=" + logref + ", message=" + message + "]";
	}
    
    
}
