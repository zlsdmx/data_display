package com.xhwl.cache;

public class LoginEntity {

	private String userId;// 登录ID
	private String mobile;// 手机号
	private long loginTime;// 登录时间
	private long lastActTime;// 最后操作时间

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}

	public long getLastActTime() {
		return lastActTime;
	}

	public void setLastActTime(long lastActTime) {
		this.lastActTime = lastActTime;
	}

}
