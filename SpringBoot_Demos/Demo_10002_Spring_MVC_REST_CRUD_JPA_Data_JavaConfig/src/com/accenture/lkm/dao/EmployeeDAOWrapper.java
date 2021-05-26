package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.bussiness.bean.EmployeeBean;
import com.accenture.lkm.entity.EmployeeEntity;

@Repository
public class EmployeeDAOWrapper {
	
	@Autowired
	private EmployeeDAO dao;
	
	public List<EmployeeBean>findAll(){
		List<EmployeeBean> list = new ArrayList<EmployeeBean>(); 
		
		Iterable<EmployeeEntity> listEn= dao.findAll();
		listEn.forEach(x->{
			EmployeeBean employee = new EmployeeBean();
			BeanUtils.copyProperties(x, employee);
			list.add(employee);
		});
		return list;
	}
	
	
	public EmployeeBean findOne(Integer id){ 
		    EmployeeEntity x= dao.findOne(id);
		    EmployeeBean employee =null;
		    if(x!=null){
		    	employee = new EmployeeBean();		
				BeanUtils.copyProperties(x, employee);
		    }
		return employee;
	}
	
	public Integer saveEmployee(EmployeeBean employee){
		EmployeeEntity employeeEntityBean = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntityBean);
		EmployeeEntity en=  dao.save(employeeEntityBean);
		return en.getId();	
	}
	
	public EmployeeBean updateEmployee(EmployeeBean employee){
		EmployeeEntity employeeEntityBean = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntityBean);
		EmployeeEntity en=  dao.save(employeeEntityBean);
		
		EmployeeBean employee2 = new EmployeeBean();
		
		BeanUtils.copyProperties(en,employee2);
		return employee2;	
	}
	
	public void delete(int id){
		dao.delete(id);
	}
	

}
