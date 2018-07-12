package com.xhwl.exception;

public enum EServerException {

	OK(200,"请求返回成功"),
	NoPermissions(-1,"没有权限访问"),
	UserIdOrPwdError(701,"用户名或密码错误"),
	ServerError(500,"服务器内部错误"),
	;
	
	
	public int status;
	public String msg;
	
	private EServerException(final int status,String msg){
		this.status = status;
		this.msg = msg;
	}
}
