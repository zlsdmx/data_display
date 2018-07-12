package com.xhwl.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * 
 * Cookie 工具类
 *
 */
public final class SessionUtils {

	protected static final Logger logger = Logger.getLogger(SessionUtils.class);

	public static final String KEY_USERID = "userId";

	public static final String KEY_TOKEN = "token";

	public static final String SESSION_ADMINID = "session_adminid";

	private static final String SESSION_VALIDATECODE = "session_validatecode";// 验证码

	/**
	 * 设置session的值
	 * 
	 * @param request
	 * @param key
	 * @param value
	 */
	public static void setAttr(HttpServletRequest request, String key, Object value) {
		request.getSession(true).setAttribute(key, value);
	}

	/**
	 * 获取session的值
	 * 
	 * @param request
	 * @param key
	 * @param value
	 */
	public static Object getAttr(HttpServletRequest request, String key) {
		return request.getSession(true).getAttribute(key);
	}

	/**
	 * 删除Session值
	 * 
	 * @param request
	 * @param key
	 */
	public static void removeAttr(HttpServletRequest request, String key) {
		request.getSession(true).removeAttribute(key);
	}

	/**
	 * 设置验证码 到session
	 * 
	 * @param request
	 * @param user
	 */
	public static void setValidateCode(HttpServletRequest request, String validateCode) {
		request.getSession(true).setAttribute(SESSION_VALIDATECODE, validateCode);
	}

	/**
	 * 从session中获取验证码
	 * 
	 * @param request
	 * @return User
	 */
	public static String getValidateCode(HttpServletRequest request) {
		return (String) request.getSession(true).getAttribute(SESSION_VALIDATECODE);
	}

	/**
	 * 从session中获删除验证码
	 * 
	 * @param request
	 * @return User
	 */
	public static void removeValidateCode(HttpServletRequest request) {
		removeAttr(request, SESSION_VALIDATECODE);
	}

}