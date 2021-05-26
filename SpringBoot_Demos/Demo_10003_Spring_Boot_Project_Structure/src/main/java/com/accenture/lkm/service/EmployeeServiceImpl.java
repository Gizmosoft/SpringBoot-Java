package com.accenture.lkm.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.bussiness.bean.EmployeeBean;
import com.accenture.lkm.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public Collection<EmployeeBean> getAllEmployee(){
		return employeeDAO.getAllEmployee();			
	}
	
	public EmployeeBean getEmployeeDetailsById(int id){
		return employeeDAO.getEmployeeDetailsById(id);
	}
	
	public Integer addEmployee(EmployeeBean employee){
		return employeeDAO.addEmployee(employee);
	}
	
	public EmployeeBean updateEmployee (EmployeeBean employee){
		return employeeDAO.updateEmployee(employee);
	}
	
	public EmployeeBean removeEmployee (int id){
		return employeeDAO.removeEmployee (id);
	}
	
}
