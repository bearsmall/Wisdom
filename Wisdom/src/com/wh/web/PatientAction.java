package com.wh.web;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wh.model.EHR2;
import com.wh.model.Patient;
import com.wh.model.User;
import com.wh.service.PatientService;
import com.wh.utils.AppException;

@SuppressWarnings("serial")
public class PatientAction extends ActionSupport {
	private Patient patient;
	private ArrayList<EHR2> ehrList;
	

	public ArrayList<EHR2> getEhrList() {
		return ehrList;
	}

	public void setEhrList(ArrayList<EHR2> ehrList) {
		this.ehrList = ehrList;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	//获取用户（Patient）的详细信息
	public String getInfo() {
		PatientService patientService = new PatientService();
		// 获取session中的session对象
		User user = (User) ActionContext.getContext().getSession().get("user");
		try {
			patient = patientService.getPatientByUser(user);
		} catch (AppException e) {
			e.printStackTrace();
		}
		if(patient!=null)
			return "success_Patient";
		else
			return "fail";
	}
	//更新Patient信息
	public String editPatient(){
		PatientService patientService = new PatientService();
		boolean flag = false;
		try {
			flag = patientService.add(patient);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag==true?"success":"fail";
	}
	public String remind(){
		return "success";
	}
	
	//获得病历列表
	public String getEHR(){
		PatientService patientService = new PatientService();
		// 获取session中的session对象
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		try {
			ehrList = patientService.getEHRs(user);
		} catch (AppException e) {
			e.printStackTrace();
		}
		if(ehrList!=null)
			return "success";
		else {
			return "fail";
		}
	}
}
