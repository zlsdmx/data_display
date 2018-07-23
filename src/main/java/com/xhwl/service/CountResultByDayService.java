package com.xhwl.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xhwl.po.CountResultByDay;

public interface CountResultByDayService {

    /**
     * 根据id查询出一个countResultByDay
     * @param id
     * @return
     */
    public CountResultByDay queryCountResultByDayById(String id);
    
    /**
     * 查询全部
     * @return
     */
    public List<CountResultByDay> queryAll();
    /**
     * 插入一条记录
     * @param countResultByDay
     * @return
     */
    public int saveCountResultByDay(CountResultByDay countResultByDay);
       
    
    /**
     * 快速分页（只查询内容，不带分页信息）
     * @param startItem
     * @param pageSize
     * @return
     */
    public List<CountResultByDay> queryByPage( int startItem, int pageSize);
    
    
    /**
     * 条件分页查询（固定条件【】可选】）
     * @param pageNum
     * @param pageSize
     * @param countResultByDay 不需要条件时是设置为null
     * @return
     */
    public PageInfo<CountResultByDay> queryByPageInfo(CountResultByDay countResultByDay, int pageNum, int pageSize);
        
    /**
     * 条件分页查询（范围条件）
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<CountResultByDay> queryByPageAndExample(String id, int pageNum, int pageSize);
    
    

    
    
    
    
     
}
