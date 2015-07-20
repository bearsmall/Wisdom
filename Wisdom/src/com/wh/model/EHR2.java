package com.wh.model;

import java.util.Date;

import com.wh.service.DoctorService;
import com.wh.utils.AppException;

/**
 * 电子病历类
 * @author Yrh
 *
 */
public class EHR2 {
	private int ID;					// 电子病历的ID 号
	private int patientID;			// 病人ID号
	private int diagnositician;		// 主治医师ID号
	private String isFirst;			// 是不是初诊
	private String performance;		// 表现
	private String checkRange;		// 检查范围
	private String diagnosis;		// 诊断
	private String suggest;			// 建议
	private String isSurgery;		// 是否手术
	private String isReferral;		// 是否转院
	private String doctorName;		// 主治医生姓名
	private Date createTime;		// 创建时间
	private int del;				// 是否删除
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getDiagnositician() {
		return diagnositician;
	}
	public void setDiagnositician(int diagnositician) {
		this.diagnositician = diagnositician;
	}
	public String getIsFirst() {
		return isFirst;
	}
	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	public String getCheckRange() {
		return checkRange;
	}
	public void setCheckRange(String checkRange) {
		this.checkRange = checkRange;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getSuggest() {
		return suggest;
	}
	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}
	public String getIsSurgery() {
		return isSurgery;
	}
	public void setIsSurgery(String isSurgery) {
		this.isSurgery = isSurgery;
	}
	public String getIsReferral() {
		return isReferral;
	}
	public void setIsReferral(String isReferral) {
		this.isReferral = isReferral;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	
	public void from_EHR_EHR2(EHR ehr){
		ID=ehr.getID();
		patientID = ehr.getPatientID();
		diagnositician=ehr.getDiagnositician();
		isFirst = ehr.getIsFirst();
		performance = ehr.getPerformance();
		checkRange = ehr.getCheckRange(); 
		diagnosis = ehr.getDiagnosis();
		suggest = ehr.getSuggest();
		isSurgery = ehr.getIsSurgery();
		isReferral = ehr.getIsReferral();
		createTime = ehr.getCreateTime();
		del = ehr.getDel();
		
		DoctorService doctorService = new DoctorService();
		try {
			doctorName = doctorService.getDoctorById(ehr.getDiagnositician()).getName();
		} catch (AppException e) {
			e.printStackTrace();
		}
	}
}
