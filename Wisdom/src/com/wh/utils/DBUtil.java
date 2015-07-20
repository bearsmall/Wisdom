package com.wh.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DBUtil数据库工具类
 * @author xiong
 * 
 */
public class DBUtil {
	private static String url = "jdbc:mysql://23.99.110.60:3306/whdb?useUnicode=true&amp;"
			+ "characterEncoding=utf8"; // 数据库连接字符串
	private static String user = "root";// 数据库账号
	private static String password = "xy196456";// 数据库密码
//	
//	private static String url = "jdbc:mysql://127.0.0.1:3306/whdb?useUnicode=true&amp;"
//			+ "characterEncoding=utf8"; // 数据库连接字符串
//	private static String user = "root";// 数据库账号
//	private static String password = "123";// 数据库密码

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载Driver驱动类，放在静态代码块中,随类的加载而加载，原因是只用加载一次就行
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得数据库连接对象：Connection
	 * @return 数据库连细节对象
	 */
	public static Connection getConnection() {
		Connection conn = null; // 声明放在try catch外部
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭数据库连接对象
	 * @param con 数据库连接对象
	 */
	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭PreparedStatement
	 * @param ps PreparedStatement对象
	 */
	public static void closePreparedStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭ResultSet
	 * @param rs ResutlSet对象
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**逐一关闭数据库连接资源
	 * @param con Connection对象
	 * @param ps PreparedStatement对象
	 * @param rs ResultSet对象
	 */
	public static void closeAll(Connection con, PreparedStatement ps,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						if (con != null) {
							try {
								con.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}