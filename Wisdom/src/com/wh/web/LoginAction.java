package com.wh.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wh.model.User;
import com.wh.service.UserService;
import com.wh.utils.AppException;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	//用户登录
	public String loginUser() {
		UserService userService = new UserService();
		int userId;
		try {
			userId = userService.login(user);
			if (userId > 0) {// 登陆成功
				System.out.println("登陆成功！userId:" + userId);
				user = userService.getUserById(userId);
				ActionContext.getContext().getSession().put("user", user);
				return "success";
			} else {
				return "fail";
			}
		} catch (AppException e) {
			e.printStackTrace();
		}
		return "fail";
	}
	
	//注销用户
	public String logoutUser(){
		ActionContext.getContext().getSession().remove("user");
		return "success";
	}
	//用户注册
	public String registUser() {
		UserService userService = new UserService();
		boolean flag = false;
		try {
			flag = userService.register(user);
		} catch (AppException e) {
			e.printStackTrace();
		}
		if(flag){
			if (user.getType().equals("4"))
				return "success_Patient";
			else if (user.getType().equals("3"))
				return "success_Doctor";
			else
				return "fail";	
		}else {
			return "fail";
		}
	}
}
