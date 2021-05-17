package com.paypal.bfs.test.employeeserv;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class HttpErrorWrapper {
	static final class ErrorCode {
		public final int code;
		public final String type;
		public final String reason;
		
		ErrorCode(HttpStatus errStatus) {
			code = errStatus.value();
			type = errStatus.name();
			reason = errStatus.getReasonPhrase();
		}
	}
	
	private final Date timestamp;
	public final String message;
	public final ErrorCode errorCode;

	public HttpErrorWrapper(Date eventTime, Exception ex, HttpStatus errStatus) {
		timestamp = eventTime;
		message = ex.getMessage();
		errorCode = new ErrorCode(errStatus);
	}

	public HttpErrorWrapper(Date eventTime, String message, HttpStatus errStatus) {
		timestamp = eventTime;
		this.message = message;
		errorCode = new ErrorCode(errStatus);
	}

	public String getTimestamp() {
		return timestamp.toInstant().toString();
	}
}

