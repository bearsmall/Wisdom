package com.wh.service;

import com.wh.dao.EHRDao;
import com.wh.dao.impl.EHRDaoImpl;
import com.wh.model.EHR;
import com.wh.utils.AppException;

public class EHRService {

	private EHRDao ehrDaoImpl = new EHRDaoImpl();

	/**
	 * 将Doctor实例插入数据库中
	 * @param doctor
	 * @return
	 * @throws AppException
	 */
	public boolean add(EHR ehr) throws AppException {
		boolean flag = false;
		if (ehrDaoImpl.add(ehr)) {
			flag = true;
		}
		return flag;
	}
}