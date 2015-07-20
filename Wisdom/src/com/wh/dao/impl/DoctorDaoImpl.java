package com.wh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.wh.dao.DoctorDao;
import com.wh.model.Doctor;
import com.wh.model.Patient;
import com.wh.model.User;
import com.wh.service.PatientService;
import com.wh.service.UserService;
import com.wh.utils.AppException;
import com.wh.utils.DBUtil;

public class DoctorDaoImpl implements DoctorDao {

	@Override
	public Doctor getDoctorById(int id) throws AppException {
		Doctor doctor = new Doctor();
		String sql = "select * from t_doctor where ID=" + id +";";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				doctor.setName(rs.getString("name"));
				doctor.setGender(((Integer)rs.getInt("gender")).toString());
				doctor.setBirthday(rs.getDate("birth").toString());
				doctor.setJob(rs.getString("job"));
				doctor.setPhoneNum(rs.getString("phoneNum"));
				doctor.setIntroduction(rs.getString("introduction"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.wh.dao.impl.DoctorDaolmpl.getDoctorById");
		}
		return doctor;
	}

	@Override
	public ArrayList<Patient> getPatients(User user) throws AppException {
		int id = user.getID();
		ArrayList<Patient> arr = new ArrayList<Patient>();
		String sql = "select distinct patientID from t_ehr where diagnositician=" + id +" order by createTime desc;";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			PatientService patientService = new PatientService();
			UserService userService = new UserService();
			while (rs.next()) {
				int patientId = rs.getInt("patientID");
				Patient patient = patientService.getPatientById(patientId);
				patient.getDataFromUser(userService.getUserById(patientId));
				arr.add(patient);
 			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.wh.dao.impl.DoctorDaolmpl.getPatients");
		}
		return arr;
	}

	@Override
	public boolean add(Doctor doctor) throws AppException {
		boolean flag = false;// 声明操作标识
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = DBUtil.getConnection();// 创建数据库连接
			String sql = "insert into t_doctor(name,gender,birth,job,phoneNum,introduction) values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, doctor.getName());
			psmt.setInt(2, Integer.parseInt(doctor.getGender()));
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date createTime = new Date();
			try {
				createTime = format.parse(doctor.getBirthday());
			} catch (ParseException e) {
				e.printStackTrace();
				throw new AppException("com.wh.dao.DoctorDaoImpl.add");
			}
			psmt.setDate(3, new java.sql.Date(createTime.getTime()));
			psmt.setString(4, doctor.getJob());
			psmt.setString(5, doctor.getPhoneNum());
			psmt.setString(6, doctor.getIntroduction());
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
