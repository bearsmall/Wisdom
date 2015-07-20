package com.wh.model;

/*
 * 病人类
 */
public class Patient extends User {
	
	private String name;			// 姓名
	private String gender = "0";	// 性别
	private String birthday;		// 出生日期
	private String marriage = "0"; 	// 是否结婚
	private String job; 			// 工作信息
	private String birthPlace; 		// 出生地
	private String nation; 			// 民族
	private String phoneNum; 		// 手机号码
	private String workAddress; 	// 工作地点
	private String introduction; 	// 个人介绍
	
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
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String brithPlace) {
		this.birthPlace = brithPlace;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
}
