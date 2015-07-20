package com.wh.dao;

import java.util.ArrayList;
import com.wh.model.EHR;
import com.wh.model.Patient;
import com.wh.model.User;
import com.wh.utils.AppException;

public interface PatientDao {
	
	/**
	 * 通过ID号码获得病人实例
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Patient getPatientById(int id) throws AppException;
	
	/**
	 * 通过User实例，获得他的电子病历集合
	 * @param user
	 * @return
	 * @throws AppException
	 */
	public ArrayList<EHR> getEHRs(User user) throws AppException;
	
	/**
	 * 将Patient实例插入数据库中
	 * @param patient
	 * @return
	 * @throws AppException
	 */
	public boolean add(Patient patient) throws AppException;
}
