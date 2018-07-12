package com.xhwl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xhwl.mapper.GroupMapper;
import com.xhwl.po.Group;
import com.xhwl.service.GroupService;

import tk.mybatis.mapper.entity.Example;
@Service
public class GroupServiceImpl extends BaseService<Group> implements GroupService {

    @Autowired
    private GroupMapper groupMapper;
    
    /**
     * 根据id查询出一个group
     * @param id
     * @return
     */
    public Group queryGroupById(int id){
        Group group = groupMapper.selectByPrimaryKey(id);
//        Group group = super.queryById(id);
        return group;
    }
    
    /**
     * 插入一条记录
     * @param group
     * @return
     */
    public int saveGroup(Group group){
        return super.save(group);
    }
    
    /**
     * 查询出_id大于num的消息,且未过期的消息
     * @param num
     * @return
     */
    public List<Group> queryUnreachedMsg(int num){
        Example example = new Example(Group.class);
        example.createCriteria()
                .andGreaterThanOrEqualTo("_id", num)
                .andGreaterThanOrEqualTo("expireTime", new Date());
        
    	List<Group> list = super.queryByExample(example);
    	return list;
    }

    /**
     * 分页查询
     */
    public List<Group> queryByPage(int startItem, int pageSize) {
//        PageRowBounds rowBounds = new PageRowBounds(pageNum, pageSize);
//        List<Group> list = groupMapper.selectByRowBounds(group, rowBounds);
        List<Group> list = super.queryByFastPage(new Group(), startItem, pageSize);
        return list;
    }
    
    
    public Integer deleteById(Long id){
        return super.deleteById(id);
    }

    
    public PageInfo<Group> queryByPageInfo(Group group, int pageNum, int pageSize) {
        return super.queryPageListByWhere(pageNum, pageSize, group);
    }

    
    public PageInfo<Group> queryByPageAndExample(Long id, int pageNum, int pageSize) {
        Example example = new Example(Group.class);
        example.createCriteria()
                .andGreaterThanOrEqualTo("id", id);
        
        PageInfo<Group> pageInfo = super.queryByPageAndExample(pageNum, pageSize, example);
        return pageInfo;
    }

    public List<Group> queryGroup(int id){
        List<Group> groups = groupMapper.getGroup3(id);
        return groups;
    }
    
    public List<Group> queryGroup4(int id){
        List<Group> groups = groupMapper.getGroup4(id);
        return groups;
    }

    public Group queryGroup5(int id){
        Group groups = groupMapper.getGroup5(id);
        return groups;
    }
}
