package com.xhwl.mapper;

import java.util.List;

import com.xhwl.po.Group;

import tk.mybatis.mapper.common.Mapper;

public interface GroupMapper extends Mapper<Group> {
    
    List<Group> getGroup3(int i);
    
    List<Group> getGroup4(int i);
    
    Group getGroup5(int i);
    
}