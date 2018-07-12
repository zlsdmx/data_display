package com.xhwl.cache;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 客户端缓存中心 只负责保存客户端登录和操作信息
 * 
 * @author mayu
 *
 */
public class ClientCacheCenter {

	private static Log log = LogFactory.getLog(ClientCacheCenter.class);

	/**
	 * 登录信息缓存 key-token value-LoginEntity
	 */
	private static Map<String, LoginEntity> loginEntityMap = new ConcurrentHashMap<String, LoginEntity>();
	
	private static final long ACT_TIME = 30 * 60 * 1000;//token心跳时间
	
	static{
		
	}
	
	
	
	public static void hearbeat(){
		final Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				for (;;) {
					log.info("执行token清理工作!");
					try {
						Iterator<Map.Entry<String, LoginEntity>> it = loginEntityMap.entrySet().iterator();  
				        while(it.hasNext()){  
				            Map.Entry<String, LoginEntity> entry = it.next();  
				            //判断是否需要移除缓存
				            if(entry.getValue().getLastActTime() + ACT_TIME <= System.currentTimeMillis())  
				                it.remove();//使用迭代器的remove()方法删除元素  
				        } 
					} catch (Exception e) {
						log.error("心跳出错:ClientCacheCenter", e);
					}

					try {
						Thread.sleep(60 * 1000);
					} catch (InterruptedException e) {
						log.error("心跳线程出错:ClientCacheCenter", e);
					}

				}
			}
		}, "HeartBeat Thread ClientCacheCenter");
		t.start();
		
	}

	
	/**
	 * 检测是否登录,登录成功返回缓存的登录信息
	 * 
	 * @param token
	 * @return LoginEntity
	 */
	public static LoginEntity getEntityByToken(String token) {
		if (token == null && !"".equals(token)) {
			return loginEntityMap.get(token);
		}

		return null;
	}

	/**
	 * 登录成功，返回token,并写入缓存
	 * 
	 * @param userId
	 * @param mobile
	 * @return
	 */
	public static String login(String userId, String mobile) {
		LoginEntity entity = new LoginEntity();
		entity.setUserId(userId);
		entity.setMobile(mobile);
		long time = System.currentTimeMillis();
		entity.setLoginTime(time);
		entity.setLastActTime(time);
		String token = createToken();
		loginEntityMap.put(token, entity);
		return token;
	}
	
	/**
	 * 登出
	 * @param token
	 */
	public static void logout(String token){
		loginEntityMap.remove(token);
	}
	
	/**
	 * 更新时间
	 * @param token
	 * @return
	 */
	public static boolean updateActTime(String token){
		if (token == null && !"".equals(token))
			return false;
		LoginEntity entity = loginEntityMap.get(token);
		if(entity == null)
			return false;
		entity.setLastActTime(System.currentTimeMillis());
		return true;
	}

	/**
	 * 创建新的token
	 * 
	 * @return
	 */
	private static String createToken() {
		return "" + System.currentTimeMillis() + random();
	}

	public static int random() {
		Random rand = new Random();
		return rand.nextInt(1000);
	}
}
