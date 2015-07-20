package com.wh.model;

import java.util.Date;

/*
 * 用户类
 */
public class User {
	int ID;				// ID 号码
	String username;	// 用户名
	String password;	// 密码
	String IDnum;		// 身份证号
	String type;		// 用户的身份
	Date createTime;	// 创建时间
	int del;			// 是否删除
	String checkPassword; //验证密码
	
	
	public String getCheckPassword() {
		return checkPassword;
	}
	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public String getIDnum() {
		return IDnum;
	}
	public void setIDnum(String iDnum) {
		IDnum = iDnum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}

}
