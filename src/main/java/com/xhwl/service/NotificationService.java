package com.xhwl.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xhwl.po.Notification;

public interface NotificationService {

    /**
     * 根据id查询出一个notification
     * @param id
     * @return
     */
    public Notification queryNotificationById(long id);
    /**
     * 插入一条记录
     * @param notification
     * @return
     */
    public int saveNotification(Notification notification);
       
    /**
     * 查询出_id大于num的且未过期的消息
     * @param num
     * @return
     */
    public List<Notification> queryUnreachedMsg(int num);
    
    /**
     * 快速分页（只查询内容，不带分页信息）
     * @param startItem
     * @param pageSize
     * @return
     */
    public List<Notification> queryByPage( int startItem, int pageSize);
    
    
    /**
     * 条件分页查询（固定条件【】可选】）
     * @param pageNum
     * @param pageSize
     * @param notification 不需要条件时是设置为null
     * @return
     */
    public PageInfo<Notification> queryByPageInfo(Notification notification, int pageNum, int pageSize);
        
    /**
     * 条件分页查询（范围条件）
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Notification> queryByPageAndExample(Long id, int pageNum, int pageSize);
    
    

    
    
    
    
     
}
