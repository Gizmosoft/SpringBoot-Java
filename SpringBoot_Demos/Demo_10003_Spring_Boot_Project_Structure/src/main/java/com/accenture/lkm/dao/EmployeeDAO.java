package com.accenture.lkm.dao;

import java.util.Collection;

import com.accenture.lkm.bussiness.bean.EmployeeBean;

public interface EmployeeDAO {

	Collection<EmployeeBean> getAllEmployee();

	EmployeeBean getEmployeeDetailsById(int id);

	Integer addEmployee(EmployeeBean employee);

	EmployeeBean updateEmployee(EmployeeBean employee);

	EmployeeBean removeEmployee(int id);

}