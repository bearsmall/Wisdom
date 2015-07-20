package com.wh.model;

/**
 * 药品类
 * @author Yrh
 *
 */
public class Drug {
	private int ID;					// 药品ID号
	private String type;			// 药品种类
	private String approvalNum;		// 批准文号
	private String approvalDate;	// 批准日期
	private String productDate;		// 生产日期
	private String shelfLife;		// 保质日期
	private String price;			// 价格
	private String pipeline;		// 流水
	private int ehrID;				// 电子病历ID号
	private int enterPriseID;		// 生产厂商ID号
	
	public int getEnterPriseID() {
		return enterPriseID;
	}
	public void setEnterPriseID(int enterPriseID) {
		this.enterPriseID = enterPriseID;
	}
	public int getEhrID() {
		return ehrID;
	}
	public void setEhrID(int ehrID) {
		this.ehrID = ehrID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getApprovalNum() {
		return approvalNum;
	}
	public void setApprovalNum(String approvalNum) {
		this.approvalNum = approvalNum;
	}
	public String getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	public String getProductDate() {
		return productDate;
	}
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPipeline() {
		return pipeline;
	}
	public void setPipeline(String pipeline) {
		this.pipeline = pipeline;
	}
}
