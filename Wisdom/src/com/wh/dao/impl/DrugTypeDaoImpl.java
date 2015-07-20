package com.wh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.wh.dao.DrugTypeDao;
import com.wh.model.DrugType;
import com.wh.utils.AppException;
import com.wh.utils.DBUtil;

public class DrugTypeDaoImpl implements DrugTypeDao {

	@Override
	public boolean add(DrugType drugType) throws AppException {
		boolean flag = false;// 声明操作标识
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = DBUtil.getConnection();// 创建数据库连接
			String sql = "insert into t_drugstype(name,anoname,type,specifi,description,isPres,createTime,del) values(?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, drugType.getName());
			psmt.setString(2, drugType.getAnoname());
			psmt.setString(3, drugType.getType());
			psmt.setString(4, drugType.getSpecifi());
			psmt.setString(5, drugType.getDescription());
			psmt.setInt(6, Integer.parseInt(drugType.getIsPres()));
			psmt.setDate(7, new java.sql.Date(new Date().getTime()));
			psmt.setInt(8, drugType.getDel());
			// 执行更新操作，返回受影响的行数
			psmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			flag = false;
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		// ...返回操作标识flag
		return flag;
	}

	@Override
	public DrugType getDrugTypeById(int id) throws AppException {
		DrugType drugType = new DrugType();
		String sql = "select * from t_drugstype where ID=" + id +";";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				drugType.setID(rs.getInt("ID"));
				drugType.setName(rs.getString("name"));
				drugType.setAnoname(rs.getString("anoname"));
				drugType.setType(rs.getString("type"));
				drugType.setSpecifi(rs.getString("specifi"));
				drugType.setDescription(rs.getString("description"));
				drugType.setIsPres(rs.getInt("isPres")+"");
				drugType.setCreateTime(rs.getDate("createTime").toString());
				drugType.setDel(rs.getInt("del"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.wh.dao.impl.DrugTypeDaoImpl.getDrugTypeById");
		}
		return drugType;
	}

}
