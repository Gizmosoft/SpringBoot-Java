package com.accenture.lkm.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.dao.EmployeeDAOWrapper;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAOWrapper employeeDAOWrapper;

	public int addEmployee(EmployeeBean employee) throws Exception {
		int result=employeeDAOWrapper.saveEmployee(employee);
		return result;
	}

	public Collection<EmployeeBean> getEmployeeDetails()throws Exception{
		return employeeDAOWrapper.findAll();
	}
	
	public EmployeeBean getEmployeeDetailByEmployeeId(int employeeId)throws Exception{
		return employeeDAOWrapper.findOne(employeeId);
	}
	public EmployeeBean deleteEmployee(int employeeId)throws Exception{
		
		EmployeeBean employee = employeeDAOWrapper.findOne(employeeId);
		if(employee!=null){
			employeeDAOWrapper.delete(employee.getEmployeeId());
		}
		return employee;
	}
	
	public EmployeeBean updateEmployee(EmployeeBean employee)throws Exception{
		EmployeeBean employee2= employeeDAOWrapper.findOne(employee.getEmployeeId());
		if(employee2!=null){
			employeeDAOWrapper.updateEmployee(employee);
		}
		return employee;
	}	
}
