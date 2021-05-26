package com.accenture.lkm.dao;

import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.EmployeeBean;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	static Map<Integer,EmployeeBean> mapOfEmloyees =  new LinkedHashMap<Integer, EmployeeBean>();
	static
	{

		
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(1989, 05, 13);
		
		Calendar dateOfJoining = Calendar.getInstance();
		dateOfBirth.set(2011, 01, 27);
		
		mapOfEmloyees.put(1001, new EmployeeBean("Jack", 1001, 20000, dateOfBirth.getTime(), dateOfJoining.getTime(), 'M'));
		
		
		//record 2
		Calendar dateOfBirth2 = Calendar.getInstance();
		dateOfBirth.set(1989, 02, 14);
		
		Calendar dateOfJoining2 = Calendar.getInstance();
		dateOfBirth.set(2011, 02, 21);
		
		mapOfEmloyees.put(1002, new EmployeeBean("Justin", 1002, 40000, dateOfBirth2.getTime(), dateOfJoining2.getTime(), 'M'));
		
		//record3
		Calendar dateOfBirth3 = Calendar.getInstance();
		dateOfBirth.set(1989, 02, 14);
		
		Calendar dateOfJoining3 = Calendar.getInstance();
		dateOfBirth.set(2011, 02, 21);
		
		mapOfEmloyees.put(1003, new EmployeeBean("Eric", 1003, 40000, dateOfBirth3.getTime(), dateOfJoining3.getTime(), 'M'));
		
		
		
		
		
		//record3
		Calendar dateOfBirth4 = Calendar.getInstance();
		dateOfBirth.set(1989, 02, 14);
		
		Calendar dateOfJoining4 = Calendar.getInstance();
		dateOfBirth.set(2011, 02, 21);
		
		mapOfEmloyees.put(1004, new EmployeeBean("Ammy", 1004, 50000, dateOfBirth4.getTime(), dateOfJoining4.getTime(), 'F'));
		
		
		Calendar dateOfBirth5 = Calendar.getInstance();
		dateOfBirth.set(1989, 02, 14);
		
		Calendar dateOfJoining5 = Calendar.getInstance();
		dateOfBirth.set(2011, 02, 21);
		
		mapOfEmloyees.put(1005, new EmployeeBean("Cynthya", 1005, 60000, dateOfBirth5.getTime(), dateOfJoining5.getTime(), 'F'));
		
	}
	
	public Collection<EmployeeBean> getAllEmployee(){
		return mapOfEmloyees.values();			
	}
	
	public EmployeeBean getEmployeeDetailsById(int id){
		return mapOfEmloyees.get(id);
	}

}
