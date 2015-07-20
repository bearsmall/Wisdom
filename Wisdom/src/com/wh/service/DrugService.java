package com.wh.service;

import com.wh.dao.DrugDao;
import com.wh.dao.impl.DrugDaoImpl;
import com.wh.model.Drug;
import com.wh.utils.AppException;

public class DrugService {
	
	private DrugDao drugDaoImpl = new DrugDaoImpl();

	/**
	 * 将Drug实例插入数据库中
	 * @param drug
	 * @return
	 * @throws AppException
	 */
	public boolean add(Drug drug) throws AppException {
		boolean flag = false;
		if (drugDaoImpl.add(drug)) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 通过药品的ID返回药品实例
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public Drug getDrugById(int id) throws AppException {
		Drug drug = null;
		drug = drugDaoImpl.getDrugById(id);
		return drug;
	}
}
