package com.wh.service;

import com.wh.dao.UserDao;
import com.wh.dao.impl.UserDaoImpl;
import com.wh.model.User;
import com.wh.utils.AppException;

public class UserService {
	private UserDao userDao = new UserDaoImpl();

	/**
	 * 注册用户
	 * @param user 待注册的用户实体对象
	 * @return 注册成功返回true否则返回false
	 * @throws AppException 异常
	 */
	public boolean register(User user) throws AppException {
		boolean flag = false;
		try {
			if (!userDao.isExit(user.getIDnum())) {// 当用户不存在的时候可以执行保存操作
				flag = userDao.add(user);// 将操作结果返回给flag
			} else {
				flag = false;
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("com.wh.service.UserService.register");
		}
		return flag;
	}

	/**用户登录
	 * @param name 用户名
	 * @param password 用户密码
	 * @return 登录用户的用户id
	 * @throws AppException
	 */
	public int login(String name, String password) throws AppException {
		int userId = -1;// 声明用户编号
		try {
			userId = userDao.login(name, password);// 根据用户名和密码查询用户id
		} catch (AppException e) {
			throw new AppException("com.wh.service.UserService.login");
		}
		return userId;
	}

	/**用户登录
	 * @param user 待登录用户实体对象
	 * @return 登录用户的用户id
	 * @throws AppException
	 */
	public int login(User user) throws AppException {
		int userId = -1;// 声明用户id编号
		try {
			userId = userDao.login(user.getUsername(), user.getPassword());// 根据用户名和密码查询用户id
		} catch (AppException e) {
			throw new AppException("com.wh.service.UserService.login");
		}
		return userId;
	}

	/**
	 * 根据ID获取用户角色
	 * @param userId 用户ID
	 * @return 返回用户角色
	 * @throws AppException 抛出异常
	 */
	public int getUserRole(int userId) throws AppException {
		// 1.初始化角色
		int role = -1;
		// 2.获取用户对应的角色编号
		role = userDao.getRoleById(userId);
		// 3.返回角色
		return role;
	}
	
	/**
	 * 通过ID号码获得User实例
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public User getUserById(int id) throws AppException {
		User user = null;
		user = userDao.getUserById(id);
		return user;
	}



}
