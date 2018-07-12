package com.xhwl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.xhwl.cache.ClientCacheCenter;
import com.xhwl.cache.LoginEntity;
import com.xhwl.exception.EServerException;
import com.xhwl.utils.SessionUtils;
import com.xhwl.utils.json.JSONUtil;

public class BaseController {

	public final static String KEY_STATUS = "status";

	public final static String KEY_MSG = "msg";

	public final static int STATUS_SUCCESS = 1;

	public final static int STATUS_FAIL = 0;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected HttpSession session;

	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request,
			HttpServletResponse response) {

		this.request = request;

		this.response = response;

		this.session = request.getSession();

	}
	
	/**
	 * 以json格式同时发送多个类型对象,可以是vo，集合，类型
	 * @param httpStatus 空值表示状态为OK
	 * @param objects
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ResponseEntity sendToClient(Object... objects) {
		List<Object> dataList = new ArrayList<Object>(); 
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", EServerException.OK.status);
		result.put("msg", EServerException.OK.msg);
		if(objects != null && objects.length > 0)
		for (Object obj : objects) {
			dataList.add(obj);
		}
		result.put("data", dataList);
		try {
			System.out.println("向客户端传递:" + JSONUtil.toJSONString(result));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(result);
	}
	
	/**
	 * 获取IP地址
	 * 
	 * @param request
	 * @return
	 */
	public String getIpAddr() {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		System.out.println("ip:" + ip);
		return ip;
	}

	/**
	 * 获取登录信息
	 * @return
	 */
	public LoginEntity getLoginEnTity(){
		String token = request.getParameter(SessionUtils.KEY_TOKEN);
		//用户没有登录返回错误给客户端
		if(StringUtils.isNotBlank(token))
			return ClientCacheCenter.getEntityByToken(token);
		return null;
	}
}
