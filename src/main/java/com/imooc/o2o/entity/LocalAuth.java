package com.imooc.o2o.entity;

import java.util.Date;

public class LocalAuth {
	// 本地授权id
	private Long localAuthId;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 创建时间
	private Date createTime;
	// 最后更新时间
	private Date lastEditTime;
	// 个人信息
	private PersonInfo psersonInfo;

	public Long getLocalAuthId() {
		return localAuthId;
	}

	public void setLocalAuthId(Long localAuthId) {
		this.localAuthId = localAuthId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public PersonInfo getPsersonInfo() {
		return psersonInfo;
	}

	public void setPsersonInfo(PersonInfo psersonInfo) {
		this.psersonInfo = psersonInfo;
	}

}
