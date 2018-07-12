package com.xhwl.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xhwl.cache.ClientCacheCenter;
import com.xhwl.mapper.UserMapper;
import com.xhwl.po.User;
import com.xhwl.service.UserService;

import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id查询出一个user
     * 
     * @param id
     * @return
     */
    public User queryUserById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        // User user = super.queryById(id);
        return user;
    }

    /**
     * 插入一条记录
     * 
     * @param user
     * @return
     */
    public int saveUser(User user) {
        return super.save(user);
    }

    /**
     * 查询出_id大于num的消息,且未过期的消息
     * 
     * @param num
     * @return
     */
    public List<User> queryUnreachedMsg(int num) {
        Example example = new Example(User.class);
        example.createCriteria().andGreaterThanOrEqualTo("_id", num).andGreaterThanOrEqualTo("expireTime", new Date());

        List<User> list = super.queryByExample(example);
        return list;
    }

    /**
     * 分页查询
     */
    public List<User> queryByPage(int startItem, int pageSize) {
        // PageRowBounds rowBounds = new PageRowBounds(pageNum, pageSize);
        // List<User> list = userMapper.selectByRowBounds(user, rowBounds);
        List<User> list = super.queryByFastPage(new User(), startItem, pageSize);
        return list;
    }

    public Integer deleteById(Long id) {
        return super.deleteById(id);
    }

    public PageInfo<User> queryByPageInfo(User user, int pageNum, int pageSize) {
        return super.queryPageListByWhere(pageNum, pageSize, user);
    }

    public PageInfo<User> queryByPageAndExample(Long id, int pageNum, int pageSize) {
        Example example = new Example(User.class);
        example.createCriteria().andGreaterThanOrEqualTo("id", id);

        PageInfo<User> pageInfo = super.queryByPageAndExample(pageNum, pageSize, example);
        return pageInfo;
    }

    @Override
    public User queryByUserIdAndPsw(String userId, String password) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(password))
            return null;
        User record = new User();
        record.setUserId(userId);
        record.setPassword(password);
        return userMapper.selectOne(record);
    }

    @Override
    public User queryByMobileAndPsw(String mobile, String password) {
        User record = new User();
        record.setMobile(mobile);
        record.setPassword(password);
        return userMapper.selectOne(record);
    }

    @Override
    public boolean addUser(User user) {
        userMapper.insert(user);
        return user.getId() > 0;
    }

    @Override
    public String login(User user) {
        user.setLastloginTime(new Date());
        user.setLoginNum(user.getLoginNum() + 1);
        // 更新user
        userMapper.updateByPrimaryKeySelective(user);

        // 生成token
        return ClientCacheCenter.login(user.getUserId(), user.getMobile());
    }

    @Override
    public User queryByUserId(String userId) {
        User record = new User();
        record.setUserId(userId);
        return super.queryOne(record);// selectOne(record);
    }

    @Override
    public User queryByMobile(String mobile) {
        User record = new User();
        record.setMobile(mobile);
        return userMapper.selectOne(record);
    }

}
