package com.wh.dao;

import com.wh.model.EHR;
import com.wh.utils.AppException;

public interface EHRDao {

	/**
	 * 将EHR实例插入数据库中
	 * @param ehr
	 * @return
	 * @throws AppException
	 */
	public boolean add(EHR ehr) throws AppException;	
}
