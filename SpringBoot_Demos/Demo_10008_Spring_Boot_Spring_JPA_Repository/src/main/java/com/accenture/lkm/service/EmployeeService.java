package com.accenture.lkm.service;

import java.util.Collection;

import com.accenture.lkm.business.bean.EmployeeBean;

public interface EmployeeService {

	int addEmployee(EmployeeBean employee) throws Exception;

	Collection<EmployeeBean> getEmployeeDetails() throws Exception;

	EmployeeBean getEmployeeDetailByEmployeeId(int employeeId) throws Exception;

	EmployeeBean deleteEmployee(int employeeId) throws Exception;

	EmployeeBean updateEmployee(EmployeeBean employee) throws Exception;

}