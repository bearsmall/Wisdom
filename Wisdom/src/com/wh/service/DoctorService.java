package com.wh.service;

import java.util.ArrayList;

import com.wh.dao.DoctorDao;
import com.wh.dao.impl.DoctorDaoImpl;
import com.wh.model.Doctor;
import com.wh.model.Patient;
import com.wh.model.User;
import com.wh.utils.AppException;

public class DoctorService {
	
	private DoctorDao doctorDaoImpl = new DoctorDaoImpl();
	
	/**
	 * 通过ID号码，获得Doctor信息
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Doctor getDoctorById(int id) throws AppException {
		Doctor doctor = null;
		doctor = doctorDaoImpl.getDoctorById(id);
		return doctor;
	}
	
	/**
	 * 通过当前User实例，获得 Doctor信息 
	 * @param id
	 * @return
	 */
	public Doctor getDoctor(User user) throws AppException {
		Doctor doctor = null;
		doctor = doctorDaoImpl.getDoctorById(user.getID());
		doctor.getDataFromUser(user);
		return doctor;
	}
	
	/**
	 * 通过当前User实例，获得他诊断的病人的集合
	 * @param user
	 * @return
	 * @throws AppException
	 */
	public ArrayList<Patient> getPatients(User user) throws AppException {
		ArrayList<Patient> arr = null;
		arr = doctorDaoImpl.getPatients(user);
		return arr;
	}
	
	/**
	 * 将Doctor实例插入数据库中
	 * @param doctor
	 * @return
	 * @throws AppException
	 */
	public boolean add(Doctor doctor) throws AppException {
		boolean flag = false;
		if (doctorDaoImpl.add(doctor)) {
			flag = true;
		}
		return flag;
	}
}
