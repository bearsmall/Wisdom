package com.wh.service;

import com.wh.dao.DrugTypeDao;
import com.wh.dao.impl.DrugTypeDaoImpl;
import com.wh.model.DrugType;
import com.wh.utils.AppException;

public class DrugTypeService {

	private DrugTypeDao drugTypeDaoImpl = new DrugTypeDaoImpl();

	/**
	 * 将Doctor实例插入数据库中
	 * @param doctor
	 * @return
	 * @throws AppException
	 */
	public boolean add(DrugType drugType) throws AppException {
		boolean flag = false;
		if (drugTypeDaoImpl.add(drugType)) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 通过id号码返回药品信息
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public DrugType getDrugTypeById(int id) throws AppException {
		DrugType drugType = null;
		drugType = drugTypeDaoImpl.getDrugTypeById(id);
		return drugType;
	}
}
