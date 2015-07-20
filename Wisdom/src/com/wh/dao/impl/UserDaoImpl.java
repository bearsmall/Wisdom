package com.wh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wh.dao.UserDao;
import com.wh.model.User;
import com.wh.utils.AppException;
import com.wh.utils.DBUtil;

public class UserDaoImpl implements UserDao {
	public boolean isExit(String idnum) throws AppException {
		Connection conn = null;
		String sql = "select *from t_user where IDnum =?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, idnum);
			rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.wh.dao.impl.UserDaoImpl.add");
		}
	}

	@Override
	public boolean add(User user) throws AppException {
		boolean flag = false;// 声明操作标识
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = DBUtil.getConnection();// 创建数据库连接
			// 声明操作语句，将用户信息保存在数据库中，“？”为占位符
			String sql = "insert into t_user(IDnum,type,createTime,del,password,username) values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, user.getIDnum());
			psmt.setInt(2, (Integer.parseInt(user.getType())));
			psmt.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
			psmt.setInt(4, user.getDel());
			psmt.setString(5, user.getPassword());
			psmt.setString(6, user.getUsername());
			// 执行更新操作，返回受影响的行数
			psmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			flag = false;
		}  finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		// ...返回操作标识flag
		return flag;
	}

	@Override
	public int login(String username, String password) throws AppException {
		// 声明数据库连接对象，预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户名和密码查询用户编号，“？”为占位符
			String sql = "select id from t_user where username=? and password =?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 填充占位符
			psmt.setString(1, username);
			psmt.setString(2, password);
			rs = psmt.executeQuery();
			// 查询到记录，提取用户编号
			if (rs.next()) {
				return rs.getInt("id");
			} else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("com.wh.dao.impl.UserDaoImpl.login");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
	}

	@Override
	public int getRoleById(int userId) throws AppException {
		int role = -1;
		// 声明数据库连接对象，预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户名和密码查询用户编号，“？”为占位符
			String sql = "select role from t_user where id=?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 填充占位符
			psmt.setInt(1, userId);
			rs = psmt.executeQuery();
			// 查询到记录，提取用户编号
			if (rs.next()) {
				role = rs.getInt("role");
			} else {
				role = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(
					"com.wh.dao.impl.UserDaoImpl.getRoleById");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return role;
	}

	@Override
	public User getUserById(int id) throws AppException {
		User user = new User();
		String sql = "select * from t_user where ID=" + id +";";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				user.setID(rs.getInt("ID"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setIDnum(rs.getString("IDnum"));
				user.setType(rs.getInt("type")+"");
				user.setCreateTime(rs.getDate("createTime"));
				user.setDel(rs.getInt("del"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.wh.dao.impl.PatientDaoImpl.getPatientById");
		}
		return user;
	}
}
