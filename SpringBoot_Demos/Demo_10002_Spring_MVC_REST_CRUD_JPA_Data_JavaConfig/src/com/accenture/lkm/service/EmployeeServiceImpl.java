package com.accenture.lkm.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.bussiness.bean.EmployeeBean;
import com.accenture.lkm.dao.EmployeeDAOWrapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAOWrapper employeeDAOWrapper;
	
	public Collection<EmployeeBean> getAllEmployee(){
		return employeeDAOWrapper.findAll();			
	}
	
	public EmployeeBean getEmployeeDetailsById(int id){
		return employeeDAOWrapper.findOne(id);
	}
	
	public Integer addEmployee(EmployeeBean employee){
		return employeeDAOWrapper.saveEmployee(employee);
	}
	
	public EmployeeBean updateEmployee (EmployeeBean employee){
		return employeeDAOWrapper.updateEmployee(employee);
	}
	
	public void removeEmployee (int id){
		employeeDAOWrapper.delete(id);
	}
	
}
