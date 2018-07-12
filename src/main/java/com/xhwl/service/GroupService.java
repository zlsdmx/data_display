package com.xhwl.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xhwl.po.Group;

public interface GroupService {

    /**
     * 根据id查询出一个group
     * @param id
     * @return
     */
    public Group queryGroupById(int id);
    /**
     * 插入一条记录
     * @param group
     * @return
     */
    public int saveGroup(Group group);
       
    /**
     * 查询出_id大于num的且未过期的消息
     * @param num
     * @return
     */
    public List<Group> queryUnreachedMsg(int num);
    
    /**
     * 快速分页（只查询内容，不带分页信息）
     * @param startItem
     * @param pageSize
     * @return
     */
    public List<Group> queryByPage( int startItem, int pageSize);
    
    
    /**
     * 条件分页查询（固定条件【】可选】）
     * @param pageNum
     * @param pageSize
     * @param group 不需要条件时是设置为null
     * @return
     */
    public PageInfo<Group> queryByPageInfo(Group group, int pageNum, int pageSize);
        
    /**
     * 条件分页查询（范围条件）
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Group> queryByPageAndExample(Long id, int pageNum, int pageSize);
    
    

    /**
     * 查询班级关联的老师和学生
     * @return
     */
    public List<Group> queryGroup(int id);
    
    public List<Group> queryGroup4(int id);
    
    public Group queryGroup5(int id);
    
     
}
