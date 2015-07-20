package com.wh.web;

import com.opensymphony.xwork2.ActionSupport;
import com.wh.model.Drug;

@SuppressWarnings("serial")
public class DrugAction extends ActionSupport {
	private Drug drug;
	
	public Drug getDrug() {
		return drug;
	}


	public void setDrug(Drug drug) {
		this.drug = drug;
	}


	public String searchDrugByName(){
		return "success";
	}
}
