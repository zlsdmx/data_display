package com.xhwl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xhwl.mapper.MyLogMapper;
import com.xhwl.po.MyLog;
import com.xhwl.service.MyLogService;

import tk.mybatis.mapper.entity.Example;
@Service
public class MyLogServiceImpl extends BaseService<MyLog> implements MyLogService {

    @Autowired
    private MyLogMapper myLogMapper;
    
    /**
     * 根据id查询出一个myLog
     * @param id
     * @return
     */
    public MyLog queryMyLogById(int id){
        MyLog myLog = myLogMapper.selectByPrimaryKey(id);
//        MyLog myLog = super.queryById(id);
        return myLog;
    }
    
    /**
     * 插入一条记录
     * @param myLog
     * @return
     */
    public int saveMyLog(MyLog myLog){
        return super.save(myLog);
    }
    
    /**
     * 查询出_id大于num的消息,且未过期的消息
     * @param num
     * @return
     */
    public List<MyLog> queryUnreachedMsg(int num){
        Example example = new Example(MyLog.class);
        example.createCriteria()
                .andGreaterThanOrEqualTo("_id", num)
                .andGreaterThanOrEqualTo("expireTime", new Date());
        
    	List<MyLog> list = super.queryByExample(example);
    	return list;
    }

    /**
     * 分页查询
     */
    public List<MyLog> queryByPage(int startItem, int pageSize) {
//        PageRowBounds rowBounds = new PageRowBounds(pageNum, pageSize);
//        List<MyLog> list = myLogMapper.selectByRowBounds(myLog, rowBounds);
        List<MyLog> list = super.queryByFastPage(new MyLog(), startItem, pageSize);
        return list;
    }
    
    
    public Integer deleteById(Long id){
        return super.deleteById(id);
    }

    
    public PageInfo<MyLog> queryByPageInfo(MyLog myLog, int pageNum, int pageSize) {
        return super.queryPageListByWhere(pageNum, pageSize, myLog);
    }

    
    public PageInfo<MyLog> queryByPageAndExample(Long id, int pageNum, int pageSize) {
        Example example = new Example(MyLog.class);
        example.createCriteria()
                .andGreaterThanOrEqualTo("id", id);
        
        PageInfo<MyLog> pageInfo = super.queryByPageAndExample(pageNum, pageSize, example);
        return pageInfo;
    }

}
