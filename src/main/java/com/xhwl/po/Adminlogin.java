package com.xhwl.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "AdminLogin")
public class Adminlogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 后台登录账号
     */
    private String adminLoginName;

    /**
     * 后台登录密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 联系手机号
     */
    private Integer mobile;

    /**
     * 管理员权限控制，用逗号隔开,例如1,3,5,11表示有权限1和3和5
     */
    private Integer popedom;

    /**
     * 管理员地址
     */
    private String address;

    /**
     * 1为超级管理员，2为普通管理员
     */
    private Integer type;

    /**
     * 管理员注册时间
     */
    private Date createTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取后台登录账号
     *
     * @return adminLoginName - 后台登录账号
     */
    public String getAdminLoginName() {
        return adminLoginName;
    }

    /**
     * 设置后台登录账号
     *
     * @param adminLoginName 后台登录账号
     */
    public void setAdminLoginName(String adminLoginName) {
        this.adminLoginName = adminLoginName == null ? null : adminLoginName.trim();
    }

    /**
     * 获取后台登录密码
     *
     * @return password - 后台登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置后台登录密码
     *
     * @param password 后台登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取真实姓名
     *
     * @return name - 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置真实姓名
     *
     * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取联系手机号
     *
     * @return mobile - 联系手机号
     */
    public Integer getMobile() {
        return mobile;
    }

    /**
     * 设置联系手机号
     *
     * @param mobile 联系手机号
     */
    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取管理员权限控制，用逗号隔开,例如1,3,5,11表示有权限1和3和5
     *
     * @return popedom - 管理员权限控制，用逗号隔开,例如1,3,5,11表示有权限1和3和5
     */
    public Integer getPopedom() {
        return popedom;
    }

    /**
     * 设置管理员权限控制，用逗号隔开,例如1,3,5,11表示有权限1和3和5
     *
     * @param popedom 管理员权限控制，用逗号隔开,例如1,3,5,11表示有权限1和3和5
     */
    public void setPopedom(Integer popedom) {
        this.popedom = popedom;
    }

    /**
     * 获取管理员地址
     *
     * @return address - 管理员地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置管理员地址
     *
     * @param address 管理员地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取1为超级管理员，2为普通管理员
     *
     * @return type - 1为超级管理员，2为普通管理员
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1为超级管理员，2为普通管理员
     *
     * @param type 1为超级管理员，2为普通管理员
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取管理员注册时间
     *
     * @return createTime - 管理员注册时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置管理员注册时间
     *
     * @param createTime 管理员注册时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}