package com.scaffold.core.exception;

@SuppressWarnings("serial")
public class ApplicationException extends Exception {
	/**
	 * 错误码，同时用于错误定位和国际化
	 */
	private String code;
	/**
	 * 可读性较好的错误消息
	 */
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
