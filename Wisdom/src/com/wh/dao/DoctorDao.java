package com.wh.dao;

import java.util.ArrayList;

import com.wh.model.Doctor;
import com.wh.model.Patient;
import com.wh.model.User;
import com.wh.utils.AppException;

public interface DoctorDao {
	
	/**
	 * 通过当前ID，获得Doctor实例
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Doctor getDoctorById(int id) throws AppException;
	
	/**
	 * 通过当前User实例，获得Patients集合
	 * @param user
	 * @return
	 * @throws AppException
	 */
	public ArrayList<Patient> getPatients(User user) throws AppException;
	
	/**
	 * 将Doctor实例插入数据库中
	 * @param doctor
	 * @return
	 * @throws AppException
	 */
	public boolean add(Doctor doctor) throws AppException;	
}