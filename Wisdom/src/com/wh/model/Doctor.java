package com.wh.model;

/*
 * 医生类
 */
public class Doctor extends User {

	private String name;			// 姓名
	private String gender="0";		// 性别
	private String birthday;		// 生日
	private String job;				// 职位
	private String phoneNum;		// 电话号码
	private String introduction;	// 介绍
	
	public void getDataFromUser(User user) {
		this.ID = user.getID();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.IDnum = user.getIDnum();
		this.type = user.getType();
		this.createTime = user.getCreateTime();
		this.del = user.getDel();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
}
