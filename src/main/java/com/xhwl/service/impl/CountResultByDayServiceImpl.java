package com.xhwl.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xhwl.mapper.CountResultByDayMapper;
import com.xhwl.po.CountResultByDay;
import com.xhwl.service.CountResultByDayService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service
public class CountResultByDayServiceImpl extends BaseService<CountResultByDay> implements CountResultByDayService {

    @Autowired
    private CountResultByDayMapper countResultByDayMapper;
    
    
	/**
     * 根据id查询出一个countResultByDay
     * @param id
     * @return
     */
    public CountResultByDay queryCountResultByDayById(String id){
        CountResultByDay countResultByDay = countResultByDayMapper.selectByPrimaryKey(id);
//        CountResultByDay countResultByDay = super.queryById(id);
        return countResultByDay;
    }
    
    /**
     * 插入一条记录
     * @param countResultByDay
     * @return
     */
    public int saveCountResultByDay(CountResultByDay countResultByDay){
        return super.save(countResultByDay);
    }
    
    /**
     * 分页查询
     */
    public List<CountResultByDay> queryByPage(int startItem, int pageSize) {
//        PageRowBounds rowBounds = new PageRowBounds(pageNum, pageSize);
//        List<CountResultByDay> list = countResultByDayMapper.selectByRowBounds(countResultByDay, rowBounds);
        List<CountResultByDay> list = super.queryByFastPage(new CountResultByDay(), startItem, pageSize);
        return list;
    }
    
    
    public Integer deleteById(String id){
        return super.deleteById(id);
    }

    
    public PageInfo<CountResultByDay> queryByPageInfo(CountResultByDay countResultByDay, int pageNum, int pageSize) {
        return super.queryPageListByWhere(pageNum, pageSize, countResultByDay);
    }

    
    public PageInfo<CountResultByDay> queryByPageAndExample(String countdate, int pageNum, int pageSize) {
        Example example = new Example(CountResultByDay.class);
        Criteria criteria = example.createCriteria();
        criteria.andGreaterThanOrEqualTo("countdate", countdate);//设置精确条件
        criteria.andLike("title", "%通知%");//设置模糊查询条件
        example.setOrderByClause("createTime");//设置排序依据列
        
        PageInfo<CountResultByDay> pageInfo = super.queryByPageAndExample(pageNum, pageSize, example);
        return pageInfo;
    }

	
    

}
