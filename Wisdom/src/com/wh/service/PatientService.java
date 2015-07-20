package com.wh.service;

import java.util.ArrayList;

import com.wh.dao.PatientDao;
import com.wh.dao.impl.PatientDaoImpl;
import com.wh.model.EHR;
import com.wh.model.EHR2;
import com.wh.model.Patient;
import com.wh.model.User;
import com.wh.utils.AppException;

public class PatientService {
	private PatientDao patientDaoImpl = new PatientDaoImpl();
	
	/**
	 * 通过ID获得Patient实例
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Patient getPatientById(int id) throws AppException {
		Patient patient = null;
		patient = patientDaoImpl.getPatientById(id);
		return patient;
	}
	
	/**
	 * 通过User获得Patient实例
	 * @param user
	 * @return
	 * @throws AppException
	 */
	public Patient getPatientByUser(User user) throws AppException {
		Patient patient = null;
		patient = getPatientById(user.getID());
		patient.getDataFromUser(user);
		return patient;
	}
	
	/**
	 * 通过User获得他的电子病历集合
	 * @param user
	 * @return
	 * @throws AppException
	 */
	public ArrayList<EHR2> getEHRs(User user) throws AppException {
		ArrayList<EHR2> arr2 = new ArrayList<EHR2>();
		ArrayList<EHR> arr = null;
		arr = patientDaoImpl.getEHRs(user);
		for (EHR ehr : arr) {
			EHR2 ehr2 = new EHR2();
			ehr2.from_EHR_EHR2(ehr);
			arr2.add(ehr2);
		}
		return arr2;
	}
	
	/**
	 * 将Patient实例插入数据库中
	 * @param patient
	 * @return
	 * @throws AppException
	 */
	public boolean add(Patient patient) throws AppException {
		boolean flag = false;
		if (patientDaoImpl.add(patient)) {
			flag = true;
		}
		return flag;
	}
}