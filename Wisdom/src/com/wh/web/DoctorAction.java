package com.wh.web;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wh.model.Doctor;
import com.wh.model.Patient;
import com.wh.model.User;
import com.wh.service.DoctorService;
import com.wh.utils.AppException;

@SuppressWarnings("serial")
public class DoctorAction extends ActionSupport {
	private Doctor doctor;
	private ArrayList<Patient> patientList;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public ArrayList<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(ArrayList<Patient> patientList) {
		this.patientList = patientList;
	}

	//查询用户（Doctor）的个人信息
	public String getInfo() {
		DoctorService doctorService = new DoctorService();
		// 获取session中的session对象
		User user = (User) ActionContext.getContext().getSession().get("user");
		try {
			doctor = doctorService.getDoctor(user);
		} catch (AppException e) {
			e.printStackTrace();
		}
		if(doctor!=null)
			return "success_Doctor";
		else
			return "fail";
	}

	//查询用户（Doctor）中所有的Patient
	public String getPatients() {
		DoctorService doctorService = new DoctorService();
		// 获取session中的session对象
		User user = (User) ActionContext.getContext().getSession().get("user");
		try {
			patientList = doctorService.getPatients(user);
		} catch (AppException e) {
			e.printStackTrace();
		}
		if (patientList != null)
			return "success";
		else
			return "fail";
	}
}