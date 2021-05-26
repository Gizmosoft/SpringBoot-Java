package com.accenture.lkm.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.accenture.lkm.bussiness.bean.EmployeeBean;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	static public Map<Integer, EmployeeBean> mapOfEmloyees = new LinkedHashMap<Integer, EmployeeBean>();
	static int count=10004;
	static
	{
		mapOfEmloyees.put(10001, new EmployeeBean("Jack",10001,12345.6,1001));
		mapOfEmloyees.put(10002, new EmployeeBean("Justin",10002,12355.6,1002));
		mapOfEmloyees.put(10003, new EmployeeBean("Eric",10003,12445.6,1003));
	}
	
	public Collection<EmployeeBean> getAllEmployee(){
		return mapOfEmloyees.values();			
	}
	
	public EmployeeBean getEmployeeDetailsById(int id){
		return mapOfEmloyees.get(id);
	}
	
	public Integer addEmployee(EmployeeBean employee){
		count++;
		employee.setEmployeeId(count);
		mapOfEmloyees.put(count, employee);
		return count;
	}
	
	public EmployeeBean updateEmployee (EmployeeBean employee){
		mapOfEmloyees.put(employee.getEmployeeId(), employee);
		return employee;
	}
	
	public EmployeeBean removeEmployee (int id){
		EmployeeBean emp= mapOfEmloyees.remove(id);
		return emp;
	}
	
}
