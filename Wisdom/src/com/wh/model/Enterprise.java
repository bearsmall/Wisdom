package com.wh.model;

public class Enterprise extends User{
	
	public void getDataFromUser(User user) {
		this.ID = user.getID();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.IDnum = user.getIDnum();
		this.type = user.getType();
		this.createTime = user.getCreateTime();
		this.del = user.getDel();
	}
	
}
