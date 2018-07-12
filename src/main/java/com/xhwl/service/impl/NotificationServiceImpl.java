package com.xhwl.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xhwl.mapper.NotificationMapper;
import com.xhwl.po.Notification;
import com.xhwl.service.NotificationService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service
public class NotificationServiceImpl extends BaseService<Notification> implements NotificationService {

    @Autowired
    private NotificationMapper notificationMapper;
    
    /**
     * 根据id查询出一个notification
     * @param id
     * @return
     */
    public Notification queryNotificationById(long id){
//        Notification notification = notificationMapper.selectByPrimaryKey(id);
        Notification notification = super.queryById(id);
        return notification;
    }
    
    /**
     * 插入一条记录
     * @param notification
     * @return
     */
    public int saveNotification(Notification notification){
        return super.save(notification);
    }
    
    /**
     * 查询出_id大于num的消息,且未过期的消息
     * @param num
     * @return
     */
    public List<Notification> queryUnreachedMsg(int num){
        Example example = new Example(Notification.class);
        example.createCriteria()
                .andGreaterThanOrEqualTo("id", num)
                .andGreaterThanOrEqualTo("expireTime", new Date());
        
    	List<Notification> list = super.queryByExample(example);
    	return list;
    }

    /**
     * 分页查询
     */
    public List<Notification> queryByPage(int startItem, int pageSize) {
//        PageRowBounds rowBounds = new PageRowBounds(pageNum, pageSize);
//        List<Notification> list = notificationMapper.selectByRowBounds(notification, rowBounds);
        List<Notification> list = super.queryByFastPage(new Notification(), startItem, pageSize);
        return list;
    }
    
    
    public Integer deleteById(Long id){
        return super.deleteById(id);
    }

    
    public PageInfo<Notification> queryByPageInfo(Notification notification, int pageNum, int pageSize) {
        return super.queryPageListByWhere(pageNum, pageSize, notification);
    }

    
    public PageInfo<Notification> queryByPageAndExample(Long id, int pageNum, int pageSize) {
        Example example = new Example(Notification.class);
        Criteria criteria = example.createCriteria();
        criteria.andGreaterThanOrEqualTo("id", id);//设置精确条件
        criteria.andLike("title", "%通知%");//设置模糊查询条件
        example.setOrderByClause("createTime");//设置排序依据列
        
        PageInfo<Notification> pageInfo = super.queryByPageAndExample(pageNum, pageSize, example);
        return pageInfo;
    }

    

}
