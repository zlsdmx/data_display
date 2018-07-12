package com.xhwl.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xhwl.po.MyLog;

public interface MyLogService {

    /**
     * 根据id查询出一个myLog
     * @param id
     * @return
     */
    public MyLog queryMyLogById(int id);
    /**
     * 插入一条记录
     * @param myLog
     * @return
     */
    public int saveMyLog(MyLog myLog);
       
    /**
     * 查询出_id大于num的且未过期的消息
     * @param num
     * @return
     */
    public List<MyLog> queryUnreachedMsg(int num);
    
    /**
     * 快速分页（只查询内容，不带分页信息）
     * @param startItem
     * @param pageSize
     * @return
     */
    public List<MyLog> queryByPage( int startItem, int pageSize);
    
    
    /**
     * 条件分页查询（固定条件【】可选】）
     * @param pageNum
     * @param pageSize
     * @param myLog 不需要条件时是设置为null
     * @return
     */
    public PageInfo<MyLog> queryByPageInfo(MyLog myLog, int pageNum, int pageSize);
        
    /**
     * 条件分页查询（范围条件）
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<MyLog> queryByPageAndExample(Long id, int pageNum, int pageSize);
    
    

}
