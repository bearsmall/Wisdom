package com.wh.utils;

@SuppressWarnings("serial")
public class AppException extends Exception {
	private int Number;
	private String Message;

	public AppException(String message) {
		this.Message = message;
	}

	public AppException(int Number, String Message) {
		super();
		this.Number = Number;
		this.Message = Message;
	}

	public int getNumber() {
		return Number;
	}

	public String getMessage() {
		return Message;
	}

}
