package com.xhwl.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xhwl.po.Cities;

public interface CitiesService {

    /**
     * 根据id查询出一个cities
     * @param id
     * @return
     */
    public Cities queryCitiesById(long id);
    
    /**
     * 查询全部
     * @return
     */
    public List<Cities> queryAll();
    /**
     * 插入一条记录
     * @param cities
     * @return
     */
    public int saveCities(Cities cities);
       
    /**
     * 查询出_id大于num的且未过期的消息
     * @param num
     * @return
     */
    public List<Cities> queryUnreachedMsg(int num);
    
    /**
     * 快速分页（只查询内容，不带分页信息）
     * @param startItem
     * @param pageSize
     * @return
     */
    public List<Cities> queryByPage( int startItem, int pageSize);
    
    
    /**
     * 条件分页查询（固定条件【】可选】）
     * @param pageNum
     * @param pageSize
     * @param cities 不需要条件时是设置为null
     * @return
     */
    public PageInfo<Cities> queryByPageInfo(Cities cities, int pageNum, int pageSize);
        
    /**
     * 条件分页查询（范围条件）
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Cities> queryByPageAndExample(Long id, int pageNum, int pageSize);
    
    

    
    
    
    
     
}
