package com.xhwl.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xhwl.po.User;

public interface UserService {

    /**
     * 根据id查询出一个user
     * @param id
     * @return
     */
    public User queryUserById(Long id);
    /**
     * 插入一条记录
     * @param user
     * @return
     */
    public int saveUser(User user);
       
    /**
     * 查询出_id大于num的且未过期的消息
     * @param num
     * @return
     */
    public List<User> queryUnreachedMsg(int num);
    
    /**
     * 快速分页（只查询内容，不带分页信息）
     * @param startItem
     * @param pageSize
     * @return
     */
    public List<User> queryByPage( int startItem, int pageSize);
    
    
    /**
     * 条件分页查询（固定条件【】可选】）
     * @param pageNum
     * @param pageSize
     * @param user 不需要条件时是设置为null
     * @return
     */
    public PageInfo<User> queryByPageInfo(User user, int pageNum, int pageSize);
        
    /**
     * 条件分页查询（范围条件）
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<User> queryByPageAndExample(Long id, int pageNum, int pageSize);
    
    
    /**
     * 根据用户ID和密码获取用户信息
     * @param userId
     * @param password
     * @return
     */
    public User queryByUserIdAndPsw(String userId,String password);
    
    /**
     * 根据手机号和密码查询
     * @param mobile
     * @param password
     * @return
     */
    public User queryByMobileAndPsw(String mobile,String password);
    
    /**
     * 新增用户
     * @param user
     */
    public boolean addUser(User user);
    
    /**
     * 用户登录逻辑
     * 1 更新用户最后登录时间和登录次数
     * 2 加入登录用户缓存
     * 3 获取登录token返回给客户端
     * @param user
     * @return
     */
    public String login(User user);
    
    public User queryByUserId(String userId);
    
    public User queryByMobile(String mobile);
}
