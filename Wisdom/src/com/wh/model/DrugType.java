package com.wh.model;

public class DrugType {

	private int ID;				// 药品类型ID
	private String name;		// 药品名
	private String anoname;		// 药品别名
	private String type;		// 药品类型（冲剂、胶囊等）
	private String specifi;		// 药品规格
	private String description;	// 其他描述（主要成分、食用禁忌、服用方法等）
	private String isPres;		// 是否为处方药
	private String createTime;	// 创建时间
	private int del;			// 是否删除
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAnoname() {
		return anoname;
	}
	public void setAnoname(String anoname) {
		this.anoname = anoname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpecifi() {
		return specifi;
	}
	public void setSpecifi(String specifi) {
		this.specifi = specifi;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIsPres() {
		return isPres;
	}
	public void setIsPres(String isPres) {
		this.isPres = isPres;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
}
