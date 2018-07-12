package com.xhwl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
import com.xhwl.po.Notification;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

public abstract class BaseService<T> {

    // 注入Mapper<T>
    @Autowired
    private Mapper<T> mapper;

    /**
     * 根据id查询数据
     * 
     * @param id
     * @return
     */
    public T queryById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有数据
     * 
     * @return
     */
    public List<T> queryAll() {
        return mapper.select(null);
    }

    /**
     * 根据条件查询一条数据，如果有多条数据会抛出异常
     * 
     * @param record
     * @return
     */
    public T queryOne(T record) {
        T selectOne = mapper.selectOne(record);
        return selectOne;
    }

    /**
     * 根据条件查询数据列表
     * 
     * @param record
     * @return
     */
    public List<T> queryListByWhere(T record) {
        return mapper.select(record);
    }

    /**
     * 条件分页查询
     * 
     * @param page
     * @param rows
     * @param record
     * @return
     */
    public PageInfo<T> queryPageListByWhere(Integer page, Integer rows, T record) {
        // 设置分页条件
        PageHelper.startPage(page, rows);
        List<T> list = this.queryListByWhere(record);
        return new PageInfo<T>(list);
    }
    
    
    
    /**
     * example条件查询
     * 
     * @param example
     * @return
     */
    public List<T> queryByExample(Example example){
        List<T> exList = mapper.selectByExample(example);
        return exList;
    }

    /**
     * 条件分页查询
     * 
     * @param page
     * @param rows
     * @param example
     * @return
     */
    public PageInfo<T> queryByPageAndExample(Integer page, Integer rows, Example example){
        
        PageHelper.startPage(page, rows);
        List<T> list = this.queryByExample(example);
        return new PageInfo<T>(list);
    }
    
    
    /**
     * 高效分页查询
     * @param startItem 起始查询条数
     * @param pageSize  每次查询条数
     * T t 直接创建一个空对象即可
     * @return
     */
    public List<T> queryByFastPage(T t, Integer startItem, Integer pageSize){
        PageRowBounds rowBounds = new PageRowBounds(startItem, pageSize);
        List<T> list = mapper.selectByRowBounds(t, rowBounds);
        return list;
    }
    

    /**
     * 新增数据，返回成功的条数
     * 
     * @param record
     * @return
     */
    public Integer save(T record) {
        return mapper.insert(record);
    }

    /**
     * 新增数据，使用不为null的字段，返回成功的条数
     * 
     * @param record
     * @return
     */
    public Integer saveSelective(T record) {
        return mapper.insertSelective(record);
    }

    /**
     * 修改数据，返回成功的条数
     * 
     * @param record
     * @return
     */
    public Integer update(T record) {
        return mapper.updateByPrimaryKey(record);
    }

    /**
     * 修改数据，使用不为null的字段，返回成功的条数
     * 
     * @param record
     * @return
     */
    public Integer updateSelective(T record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据id删除数据
     * 
     * @param id
     * @return
     */
    public Integer deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * 
     * @param clazz
     * @param property
     * @param values
     * @return
     */
    public Integer deleteByIds(Class<T> clazz, String property, List<Object> values) {
        Example example = new Example(clazz);
        example.createCriteria().andIn(property, values);
        return mapper.deleteByExample(example);
    }

    /**
     * 条件做删除
     * 
     * @param record
     * @return
     */
    public Integer deleteByWhere(T record) {
        return mapper.delete(record);
    }

}