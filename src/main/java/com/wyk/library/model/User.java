package com.wyk.library.model;

import java.util.Date;

public class User extends BaseModel {

	private static final long serialVersionUID = 3474323268481100686L;
	
	/** 匿名用户 */
	public static final User Anonymous;

	/** 用户名 */
	private String name;
	
	/** 密码 */
	private String password;
	
	/** 手机号 */
	private String mobile;
	
	/** 昵称 */
	private String nickname;
	
	/** 性别 */
	private Integer sex;
	
	/** 头像url */
	private String protraitUrl;
	
	/** 注册时间 */
	private Date regTime;
	
	/**
	 * 匿名用户初始化
	 */
	static {
		Anonymous = new User();
		Anonymous.setId(0L);
		Anonymous.setName("anonymous");
		Anonymous.setNickname("匿名用户");
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the sex
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	/**
	 * @return the protraitUrl
	 */
	public String getProtraitUrl() {
		return protraitUrl;
	}

	/**
	 * @param protraitUrl the protraitUrl to set
	 */
	public void setProtraitUrl(String protraitUrl) {
		this.protraitUrl = protraitUrl;
	}

	/**
	 * @return the regTime
	 */
	public Date getRegTime() {
		return regTime;
	}

	/**
	 * @param regTime the regTime to set
	 */
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	
}
