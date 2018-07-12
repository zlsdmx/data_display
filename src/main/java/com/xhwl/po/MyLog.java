package com.xhwl.po;

import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "my_log")
public class MyLog {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @Column(name = "login_account")
    private String loginAccount;

    @Column(name = "login_ip")
    private String loginIp;

    @Column(name = "action_url")
    private String actionUrl;

    private String module;

    private String method;

    @Column(name = "action_time")
    private Long actionTime;

    private String description;

    @Column(name = "gmt_create")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")// HH:mm:ss
    private Date gmtCreate;

    private Byte state;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return login_account
     */
    public String getLoginAccount() {
        return loginAccount;
    }

    /**
     * @param loginAccount
     */
    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    /**
     * @return login_ip
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * @param loginIp
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * @return action_url
     */
    public String getActionUrl() {
        return actionUrl;
    }

    /**
     * @param actionUrl
     */
    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl == null ? null : actionUrl.trim();
    }

    /**
     * @return module
     */
    public String getModule() {
        return module;
    }

    /**
     * @param module
     */
    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    /**
     * @return method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * @return action_time
     */
    public Long getActionTime() {
        return actionTime;
    }

    /**
     * @param actionTime
     */
    public void setActionTime(Long actionTime) {
        this.actionTime = actionTime;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return gmt_create
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return state
     */
    public Byte getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "MyLog [id=" + id + ", loginAccount=" + loginAccount + ", loginIp=" + loginIp + ", actionUrl=" + actionUrl + ", module=" + module + ", method="
                + method + ", actionTime=" + actionTime + ", description=" + description + ", gmtCreate=" + gmtCreate + ", state=" + state + "]";
    }
    
    
}