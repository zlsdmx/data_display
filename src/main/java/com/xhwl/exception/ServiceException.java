package com.xhwl.exception;

public class ServiceException extends Exception {

	private int status;

	private String msg;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	
	public ServiceException(EServerException e) {
		this.status = e.status;
		this.msg = e.msg;
	}

	public int getStatus() {
		return status;
	}

	public String getMsg() {
		return msg;
	}

}
