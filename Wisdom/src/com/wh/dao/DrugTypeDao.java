package com.wh.dao;

import com.wh.model.DrugType;
import com.wh.utils.AppException;

public interface DrugTypeDao {

	/**
	 * 将DrugType实例插入数据库中
	 * @param drugType
	 * @return
	 * @throws AppException
	 */
	public boolean add(DrugType drugType) throws AppException;	
	
	/**
	 * 通过id号码返回DrugType实例
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public DrugType getDrugTypeById(int id) throws AppException;
}
