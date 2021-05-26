package com.accenture.lkm.service;

import java.util.Collection;

import com.accenture.lkm.business.bean.EmployeeBean;

public interface EmployeeService {

	Collection<EmployeeBean> getAllEmployee();

	EmployeeBean getEmployeeDetailsById(int id);

}