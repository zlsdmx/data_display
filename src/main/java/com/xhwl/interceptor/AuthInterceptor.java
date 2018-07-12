package com.xhwl.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xhwl.annotation.Auth;
import com.xhwl.cache.ClientCacheCenter;
import com.xhwl.exception.EServerException;
import com.xhwl.utils.SessionUtils;
import com.xhwl.utils.json.HtmlUtil;

/**
 * 权限拦截器
  *
 */
public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	private static Log log = LogFactory.getLog(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//log.info("AuthInterceptor preHandle!");
		try{
			HandlerMethod method = (HandlerMethod)handler;
			Auth  auth = method.getMethod().getAnnotation(Auth.class);
			//需要客户端验证
			if( auth != null && auth.checkUserLogin()){
				String token = request.getParameter(SessionUtils.KEY_TOKEN);
				//用户没有登录返回错误给客户端
				if(StringUtils.isBlank(token) || ClientCacheCenter.getEntityByToken(token) == null){
					Map<String, Object> result = new HashMap<String, Object>();
					result.put("status", EServerException.NoPermissions.status);
					result.put("msg", EServerException.NoPermissions.msg);
					result.put("data", null);
					HtmlUtil.writerJson(response, result);//没有权限访问该地址
					return false;
				}
				//返回成功,进入到controller层
				return true;
			}
			//需要服务端验证
			if( auth != null && auth.checkAdminLogin()){
				Object adminId = SessionUtils.getAttr(request, SessionUtils.SESSION_ADMINID);
				//用户没有登录返回错误给客户端
				if(adminId  == null){
					HtmlUtil.writerJson(response, "status:-1");//没有权限访问该地址
					return false;
				}
				return true;
			}
		}catch(Exception e){
			return super.preHandle(request, response, handler);
		}
		return super.preHandle(request, response, handler);
	}
}
