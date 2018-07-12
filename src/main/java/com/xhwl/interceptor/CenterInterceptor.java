package com.xhwl.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xhwl.cache.ClientCacheCenter;
import com.xhwl.exception.EServerException;
import com.xhwl.exception.ServiceException;
import com.xhwl.utils.SessionUtils;
import com.xhwl.utils.json.HtmlUtil;

/**
 * 中心拦截器
 * 日志记录
 */
public class CenterInterceptor extends HandlerInterceptorAdapter{
	
	private static Log log = LogFactory.getLog(CenterInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)    
	        throws Exception {   
		//log.info("CenterInterceptor preHandle");
		return true;    
	}   
	
	@Override
    public void postHandle(    
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)    
            throws Exception {    
		//log.info("CenterInterceptor postHandle");
    }    
    
    @Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
    	//log.info("CenterInterceptor afterCompletion");
    	//拦截业务异常信息
    	if(ex != null){
    		int status = EServerException.OK.status;
			String msg = "";
			if (ex instanceof ServiceException) {
				msg = ((ServiceException)ex).getMsg();
				status = ((ServiceException)ex).getStatus();
			}else {
				//服务器内部错误
				status = EServerException.ServerError.status;
				msg = ex.toString();
			}
			//logger(request, handler, ex);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("status", status);
			result.put("msg", msg);
			result.put("data", null);
			HtmlUtil.writerJson(response, result);
		}else{
			super.afterCompletion(request, response, handler, ex);
		}
    	//token存在,更新操作时间
		String token = request.getParameter(SessionUtils.KEY_TOKEN);
		if(StringUtils.isNotBlank(token))
			ClientCacheCenter.updateActTime(token);
	}
}
