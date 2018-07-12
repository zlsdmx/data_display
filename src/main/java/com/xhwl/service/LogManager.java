package com.xhwl.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 日志类
 * 
 */
public class LogManager {

	private final static Log visitLog = LogFactory.getLog("visit");
	
	private final static String SPLIT = "|";
	
	/**
	 * 登录日志
	 */
	public static void visit(String url,String ip,String userId) {
		StringBuilder sb = new StringBuilder();
		sb.append(url).append(SPLIT);
		sb.append(ip).append(SPLIT);
		sb.append(userId);
		visitLog.info(sb.toString());
	}

	
}
