package com.wh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.wh.dao.PatientDao;
import com.wh.model.EHR;
import com.wh.model.Patient;
import com.wh.model.User;
import com.wh.utils.AppException;
import com.wh.utils.DBUtil;

public class PatientDaoImpl implements PatientDao{

	@Override
	public Patient getPatientById(int id) throws AppException {
		Patient patient = new Patient();
		String sql = "select * from t_patient where ID=" + id +";";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				patient.setName(rs.getString("name"));
				patient.setGender(((Integer)rs.getInt("gender")).toString());
				patient.setBirthday(rs.getDate("birth").toString());
				patient.setMarriage(((Integer)rs.getInt("marriage")).toString());
				patient.setJob(rs.getString("job"));
				patient.setBirthPlace(rs.getString("birthPlace"));
				patient.setNation(rs.getString("nation"));
				patient.setPhoneNum(rs.getString("phoneNum"));
				patient.setWorkAddress(rs.getString("workAddress"));
				patient.setIntroduction(rs.getString("introduction"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.wh.dao.impl.PatientDaoImpl.getPatientById");
		}
		return patient;
	}

	@Override
	public ArrayList<EHR> getEHRs(User user) throws AppException {
		int id = user.getID();
		ArrayList<EHR> arr = new ArrayList<EHR>();
		String sql = "select * from t_ehr where patientID=" + id +";";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				EHR ehr = new EHR();
				ehr.setID(rs.getInt("ID"));
				ehr.setPatientID(rs.getInt("patientID"));
				ehr.setDiagnositician(rs.getInt("diagnositician"));
				ehr.setIsFirst(((Integer)rs.getInt("isFirst")).toString());
				ehr.setPerformance(rs.getString("performance"));
				ehr.setCheckRange(rs.getString("checkRange"));
				ehr.setDiagnosis(rs.getString("diagnosis"));
				ehr.setSuggest(rs.getString("suggest"));
				ehr.setIsSurgery(((Integer)rs.getInt("isSurgery")).toString());
				ehr.setIsReferral(((Integer)rs.getInt("isReferral")).toString());
				ehr.setCreateTime(rs.getDate("createTime"));
				ehr.setDel(rs.getInt("del"));
				
				arr.add(ehr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.wh.dao.impl.PatientDaoImpl.getEHRs");
		}
		return arr;
	}

	@Override
	public boolean add(Patient patient) throws AppException {
		boolean flag = false;// 声明操作标识
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = DBUtil.getConnection();// 创建数据库连接
			String sql = "insert into t_patient(name,gender,birth,marriage,job,birthPlace,nation,phoneNum,workAddress,introduction) values(?,?,?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, patient.getName());
			psmt.setInt(2, Integer.parseInt(patient.getGender()));
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date createTime = new Date();
			try {
				createTime = format.parse(patient.getBirthday());
			} catch (ParseException e) {
				e.printStackTrace();
				throw new AppException("com.wh.dao.PatientDaoImpl.add");
			}
			psmt.setDate(3, new java.sql.Date(createTime.getTime()));
			psmt.setInt(4, Integer.parseInt(patient.getMarriage()));
			psmt.setString(5, patient.getJob());
			psmt.setString(6, patient.getBirthday());
			psmt.setString(7, patient.getNation());
			psmt.setString(8, patient.getPhoneNum());
			psmt.setString(9, patient.getWorkAddress());
			psmt.setString(10, patient.getIntroduction());
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
}
