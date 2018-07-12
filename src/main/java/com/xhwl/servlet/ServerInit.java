package com.xhwl.servlet;

import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xhwl.cache.ClientCacheCenter;
import com.xhwl.cache.IndexCache;

public class ServerInit extends HttpServlet {
	private static Log log = LogFactory.getLog(ServerInit.class);

	public static boolean hasRun = false;
	/**
	 * 
	 */
	private static final long serialVersionUID = 374084557551254887L;

	@Override
	public void init() {
		if (hasRun)
			return;
		long start = System.currentTimeMillis();
		try {
			//检测连接数据库是否成功
			
			//刷新首页数据
			IndexCache.hearbeat();
			// 刷新token列表，过期清除掉
			ClientCacheCenter.hearbeat();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e, e);
		}
		hasRun = true;
		log.info("服务端初始化完毕!耗时:" + (System.currentTimeMillis() - start) + "毫秒");
	}

}
