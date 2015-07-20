package com.wh.dao;

import com.wh.model.Drug;
import com.wh.utils.AppException;

public interface DrugDao {

	/**
	 * 将Drug实例插入数据库中
	 * @param drug
	 * @return
	 * @throws AppException
	 */
	public boolean add(Drug drug) throws AppException;	
	
	/**
	 * 通过药品的ID返回药品实例
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Drug getDrugById(int id) throws AppException;
}
