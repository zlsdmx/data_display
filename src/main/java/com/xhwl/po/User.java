package com.xhwl.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 手机号（绑定手机）
	 */
	private String mobile;

	/**
	 * 用户名称
	 */
	@Column(name = "user_Id")
	private String userId;

	/**
	 * 邮箱（只有注册时候使用，绑定邮箱时作为一个默认选项）
	 */
	private String email;

	/**
	 * 绑定邮箱（当确认绑定邮箱后使用都会此邮箱）
	 */
	@Column(name = "bind_Email")
	private String bindEmail;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 真实姓名
	 */
	@Column(name = "user_Name")
	private String userName;

	/**
	 * 性别
	 */
	private Integer gender;

	/**
	 * 所在省份
	 */
	private String province;

	/**
	 * 所在城市
	 */
	private String city;

	/**
	 * 所在街道
	 */
	private String street;

	/**
	 * QQ号码
	 */
	private Long qq;

	/**
	 * 创建时间
	 */
	@Column(name = "create_Time")
	private Date createTime ;//= new Date();

	/**
	 * 登录次数
	 */
	@Column(name = "login_Num")
	private Integer loginNum ;//=0;

	/**
	 * 最后登录时间
	 */
	@Column(name = "lastlogin_Time")
	private Date lastloginTime ;//= new Date();

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
	 * 获取手机号（绑定手机）
	 *
	 * @return mobile - 手机号（绑定手机）
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置手机号（绑定手机）
	 *
	 * @param mobile
	 *            手机号（绑定手机）
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	/**
	 * 获取用户名称
	 *
	 * @return user_Id - 用户名称
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 设置用户名称
	 *
	 * @param userId
	 *            用户名称
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	/**
	 * 获取邮箱（只有注册时候使用，绑定邮箱时作为一个默认选项）
	 *
	 * @return email - 邮箱（只有注册时候使用，绑定邮箱时作为一个默认选项）
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置邮箱（只有注册时候使用，绑定邮箱时作为一个默认选项）
	 *
	 * @param email
	 *            邮箱（只有注册时候使用，绑定邮箱时作为一个默认选项）
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	/**
	 * 获取绑定邮箱（当确认绑定邮箱后使用都会此邮箱）
	 *
	 * @return bind_Email - 绑定邮箱（当确认绑定邮箱后使用都会此邮箱）
	 */
	public String getBindEmail() {
		return bindEmail;
	}

	/**
	 * 设置绑定邮箱（当确认绑定邮箱后使用都会此邮箱）
	 *
	 * @param bindEmail
	 *            绑定邮箱（当确认绑定邮箱后使用都会此邮箱）
	 */
	public void setBindEmail(String bindEmail) {
		this.bindEmail = bindEmail == null ? null : bindEmail.trim();
	}

	/**
	 * 获取密码
	 *
	 * @return password - 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 *
	 * @param password
	 *            密码
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * 获取真实姓名
	 *
	 * @return user_Name - 真实姓名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置真实姓名
	 *
	 * @param userName
	 *            真实姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	/**
	 * 获取性别
	 *
	 * @return gender - 性别
	 */
	public Integer getGender() {
		return gender;
	}

	/**
	 * 设置性别
	 *
	 * @param gender
	 *            性别
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	/**
	 * 获取所在省份
	 *
	 * @return province - 所在省份
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 设置所在省份
	 *
	 * @param province
	 *            所在省份
	 */
	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	/**
	 * 获取所在城市
	 *
	 * @return city - 所在城市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置所在城市
	 *
	 * @param city
	 *            所在城市
	 */
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	/**
	 * 获取所在街道
	 *
	 * @return street - 所在街道
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * 设置所在街道
	 *
	 * @param street
	 *            所在街道
	 */
	public void setStreet(String street) {
		this.street = street == null ? null : street.trim();
	}

	/**
	 * 获取QQ号码
	 *
	 * @return qq - QQ号码
	 */
	public Long getQq() {
		return qq;
	}

	/**
	 * 设置QQ号码
	 *
	 * @param qq
	 *            QQ号码
	 */
	public void setQq(Long qq) {
		this.qq = qq;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
	}

	public Date getLastloginTime() {
		return lastloginTime;
	}

	public void setLastloginTime(Date lastloginTime) {
		this.lastloginTime = lastloginTime;
	}

}