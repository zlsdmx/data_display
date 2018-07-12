package com.xhwl.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xhwl.exception.EServerException;
import com.xhwl.exception.ServiceException;
import com.xhwl.po.User;
import com.xhwl.service.UserService;
import com.xhwl.utils.SessionUtils;

@RequestMapping(value="home")
@Controller
public class HomeController extends BaseController{

	@Autowired
    private UserService userService;
	
	/**
	 * 首页
	 * 使用懒加载，客户端不发送token，本地有token，昵称的先显示
	 * 当用户点击个人中心时候再发token,进行判断是否需要登录 
	 * @return
	 * @throws Exception
	 */
    @SuppressWarnings("rawtypes")
	@RequestMapping("/index")       
    public ResponseEntity index() throws Exception{
        
        return this.sendToClient();
    }
    
    /**
     * 账号密码登录
     * @param userId
     * @param password
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping("/login")       
    public ResponseEntity login(String userId,String password) throws Exception{
    	//输入数据有误
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(password))
        	throw new ServiceException(EServerException.UserIdOrPwdError.status,
        			EServerException.UserIdOrPwdError.msg); 
        //用户查询不到
        User user = userService.queryByUserIdAndPsw(userId, password);
        if(user == null){
        	throw new ServiceException(EServerException.UserIdOrPwdError.status,
        			EServerException.UserIdOrPwdError.msg); 
        }
        Map<String,String> result = new HashMap<String,String>();
        result.put(SessionUtils.KEY_TOKEN, userService.login(user));
        return this.sendToClient(result);
    }
    
    /**
     * 手机验证码登录
     * @param mobile
     * @param code 验证码
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping("/mobilelogin")       
    public ResponseEntity mobilelogin(String mobile,String password) throws Exception{
    	//输入数据有误
        if(StringUtils.isBlank(mobile) || StringUtils.isBlank(password))
        	throw new ServiceException(EServerException.UserIdOrPwdError.status,
        			EServerException.UserIdOrPwdError.msg); 
    	//用户查询不到
        User user = userService.queryByMobileAndPsw(mobile, password);
        if(user == null){
        	throw new ServiceException(EServerException.UserIdOrPwdError.status,
        			EServerException.UserIdOrPwdError.msg); 
        }
        Map<String,String> result = new HashMap<String,String>();
        result.put(SessionUtils.KEY_TOKEN, userService.login(user));
        return this.sendToClient(result);
    }
    
    /**
     * 用户注册
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("/reg")   
	public ResponseEntity reg(String userId,String mobile,String password) throws Exception{
    	//输入数据有误
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(password) 
        		|| StringUtils.isBlank(mobile))
        	throw new ServiceException(EServerException.UserIdOrPwdError.status,
        			EServerException.UserIdOrPwdError.msg); 
        User user = new User();
        user.setUserId(userId);
        user.setMobile(mobile);
        user.setPassword(password);
        boolean bln = userService.addUser(user);
        //新增出错，抛出服务器内部错误
        if(!bln){
        	throw new ServiceException(EServerException.ServerError.status,
        			EServerException.ServerError.msg); 
        }
        Map<String,String> result = new HashMap<String,String>();
        result.put(SessionUtils.KEY_TOKEN, userService.login(user));
    	return this.sendToClient(result);
    }
    
    /**
     * 判断是否已经注册
     * @param id
     * @param type 1-用户id 2-手机号
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping("/isReg")       
    public ResponseEntity isReg(String id,int type) throws Exception{
    	 if(StringUtils.isBlank(id)){
    		 throw new ServiceException(EServerException.ServerError.status,
         			EServerException.ServerError.msg); 
    	 }
    	 boolean isReg = false;
    	 //查询该用户id是否被注册
    	 if(type == 1 && userService.queryByUserId(id) != null){
    		 isReg = true;
    	 //查询该手机号是否注册
    	 }else if(type == 2 && userService.queryByMobile(id) != null){
    		 isReg = true; 
    	 }else{
    		 throw new ServiceException(EServerException.ServerError.status,
          			EServerException.ServerError.msg); 
    	 }
    	 Map<String,Boolean> result = new HashMap<String,Boolean>();
         result.put("isReg", isReg);
        return this.sendToClient(result);
    }
}
