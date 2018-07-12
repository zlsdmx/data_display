package com.xhwl.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xhwl.mapper.CitiesMapper;
import com.xhwl.po.Cities;
import com.xhwl.service.CitiesService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service
public class CitiesServiceImpl extends BaseService<Cities> implements CitiesService {

    @Autowired
    private CitiesMapper citiesMapper;
    
    /**
     * 根据id查询出一个cities
     * @param id
     * @return
     */
    public Cities queryCitiesById(long id){
//        Cities cities = citiesMapper.selectByPrimaryKey(id);
        Cities cities = super.queryById(id);
        return cities;
    }
    
    /**
     * 插入一条记录
     * @param cities
     * @return
     */
    public int saveCities(Cities cities){
        return super.save(cities);
    }
    
    /**
     * 查询出_id大于num的消息,且未过期的消息
     * @param num
     * @return
     */
    public List<Cities> queryUnreachedMsg(int num){
        Example example = new Example(Cities.class);
        example.createCriteria()
                .andGreaterThanOrEqualTo("id", num)
                .andGreaterThanOrEqualTo("expireTime", new Date());
        
    	List<Cities> list = super.queryByExample(example);
    	return list;
    }

    /**
     * 分页查询
     */
    public List<Cities> queryByPage(int startItem, int pageSize) {
//        PageRowBounds rowBounds = new PageRowBounds(pageNum, pageSize);
//        List<Cities> list = citiesMapper.selectByRowBounds(cities, rowBounds);
        List<Cities> list = super.queryByFastPage(new Cities(), startItem, pageSize);
        return list;
    }
    
    
    public Integer deleteById(Long id){
        return super.deleteById(id);
    }

    
    public PageInfo<Cities> queryByPageInfo(Cities cities, int pageNum, int pageSize) {
        return super.queryPageListByWhere(pageNum, pageSize, cities);
    }

    
    public PageInfo<Cities> queryByPageAndExample(Long id, int pageNum, int pageSize) {
        Example example = new Example(Cities.class);
        Criteria criteria = example.createCriteria();
        criteria.andGreaterThanOrEqualTo("id", id);//设置精确条件
        criteria.andLike("title", "%通知%");//设置模糊查询条件
        example.setOrderByClause("createTime");//设置排序依据列
        
        PageInfo<Cities> pageInfo = super.queryByPageAndExample(pageNum, pageSize, example);
        return pageInfo;
    }

    

}
