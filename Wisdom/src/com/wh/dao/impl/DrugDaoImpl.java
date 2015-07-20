package com.wh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.wh.dao.DrugDao;
import com.wh.model.Drug;
import com.wh.utils.AppException;
import com.wh.utils.DBUtil;

public class DrugDaoImpl implements DrugDao {

	@Override
	public boolean add(Drug drug) throws AppException {
		boolean flag = false;// 声明操作标识
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = DBUtil.getConnection();// 创建数据库连接
			String sql = "insert into t_drugs(t_d_ID,approvalNum,approvalDate,productDate,shelfLife,price,pipeline,ehrID,enterpriseID) values(?,?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setInt(1, Integer.parseInt(drug.getType()));
			psmt.setString(2, drug.getApprovalNum());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date approvalDate = new Date();
			try {
				approvalDate = format.parse(drug.getApprovalDate());
			} catch (ParseException e) {
				e.printStackTrace();
				throw new AppException("com.wh.dao.DrugDaoImpl.add");
			}
			psmt.setDate(3, new java.sql.Date(approvalDate.getTime()));
			
			Date productDate = new Date();
			try {
				productDate = format.parse(drug.getProductDate());
			} catch (ParseException e) {
				e.printStackTrace();
				throw new AppException("com.wh.dao.DrugDaoImpl.add");
			}
			psmt.setDate(4, new java.sql.Date(productDate.getTime()));
			
			Date shelfLife = new Date();
			try {
				shelfLife = format.parse(drug.getShelfLife());
			} catch (ParseException e) {
				e.printStackTrace();
				throw new AppException("com.wh.dao.DrugDaoImpl.add");
			}
			psmt.setDate(5, new java.sql.Date(shelfLife.getTime()));
			
			psmt.setFloat(6, Float.parseFloat(drug.getPrice()));
			psmt.setString(7, drug.getPipeline());
			psmt.setInt(8, drug.getEhrID());
			psmt.setInt(9, drug.getEnterPriseID());
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
	public Drug getDrugById(int id) throws AppException {
		Drug drug = new Drug();
		String sql = "select * from t_drugs where ID=" + id +";";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				drug.setID(id);
				drug.setType(rs.getString("type"));
				drug.setApprovalNum(rs.getString("approvalNum"));
				drug.setApprovalDate(rs.getDate("approvalDate").toString());
				drug.setProductDate(rs.getDate("productDate").toString());
				drug.setShelfLife(rs.getDate("shelfLife").toString());
				drug.setPrice(rs.getFloat("price")+"");
				drug.setPipeline(rs.getString("pipeline"));
				drug.setEhrID(rs.getInt("ehrID"));
				drug.setEnterPriseID(rs.getInt("enterpriseID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.wh.dao.impl.DrugDaoImpl.getDrugById");
		}
		return drug;
	}
}
