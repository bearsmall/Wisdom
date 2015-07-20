package com.wh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.wh.dao.EHRDao;
import com.wh.model.EHR;
import com.wh.utils.AppException;
import com.wh.utils.DBUtil;

public class EHRDaoImpl implements EHRDao {

	@Override
	public boolean add(EHR ehr) throws AppException {
		boolean flag = false;// 声明操作标识
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = DBUtil.getConnection();// 创建数据库连接
			String sql = "insert into t_ehr(patientID,diagnositician,isFirst,performance,checkRange,diagnosis,suggest,isSurgery,isReferral,createTime,del) values(?,?,?,?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setInt(1, ehr.getPatientID());
			psmt.setInt(2, ehr.getDiagnositician());
			psmt.setInt(3, Integer.parseInt(ehr.getIsFirst()));
			psmt.setString(4, ehr.getPerformance());
			psmt.setString(5, ehr.getCheckRange());
			psmt.setString(6, ehr.getDiagnosis());
			psmt.setString(7, ehr.getSuggest());
			psmt.setInt(8, Integer.parseInt(ehr.getIsSurgery()));
			psmt.setInt(9, Integer.parseInt(ehr.getIsReferral()));
			psmt.setDate(10, new java.sql.Date(new Date().getTime()));
			psmt.setInt(11, ehr.getDel());
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

}
