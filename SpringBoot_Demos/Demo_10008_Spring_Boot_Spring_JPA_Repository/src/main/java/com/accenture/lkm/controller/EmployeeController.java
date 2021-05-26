package com.accenture.lkm.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.service.EmployeeService;

@RestController
// extends @Controller
// object are automatically converted to JSON or XML
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	@RequestMapping(value="emp/controller/getDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<EmployeeBean>> getEmployeeDetails() throws Exception{
		Collection <EmployeeBean> listEmployee = employeeService.getEmployeeDetails();
		return new ResponseEntity<Collection<EmployeeBean>>(listEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(value="emp/controller/getDetailsById/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> getEmployeeDetailByEmployeeId(@PathVariable("id") int myId) throws Exception{
		EmployeeBean employee = employeeService.getEmployeeDetailByEmployeeId(myId);
		
		if(employee!=null)
		{
			return new ResponseEntity<EmployeeBean>(employee,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<EmployeeBean>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/emp/controller/addEmp",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeBean employee) throws Exception{
		int id= employeeService.addEmployee(employee);
		return new ResponseEntity<String>("Employee added successfully with id:"+id,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/emp/controller/updateEmp",
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> updateEmployee(@RequestBody EmployeeBean employee) throws Exception{
		EmployeeBean employee2= employeeService.updateEmployee(employee);
		if(employee2==null){
			return new ResponseEntity<EmployeeBean>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<EmployeeBean>(employee2,HttpStatus.OK);
	}
	@RequestMapping(value="/emp/controller/deleteEmp/{id}",
			method=RequestMethod.DELETE,
			//consumes=MediaType.TEXT_PLAIN_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> deleteEmployee(@PathVariable("id") int myId) throws Exception{
		EmployeeBean employee= employeeService.deleteEmployee(myId);
		if(employee==null){
			return new ResponseEntity<EmployeeBean>(employee,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<EmployeeBean>(employee,HttpStatus.OK);
	}
}
