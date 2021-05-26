package com.accenture.lkm.dao;

import java.util.Collection;

import com.accenture.lkm.business.bean.EmployeeBean;

public interface EmployeeDAO {

	Collection<EmployeeBean> getAllEmployee();

	EmployeeBean getEmployeeDetailsById(int id);

}