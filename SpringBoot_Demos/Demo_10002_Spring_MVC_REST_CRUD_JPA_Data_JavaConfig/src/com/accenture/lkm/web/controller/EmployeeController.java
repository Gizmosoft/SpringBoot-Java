package com.accenture.lkm.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.bussiness.bean.EmployeeBean;
import com.accenture.lkm.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@RequestMapping(value = "emp/controller/getDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeBean>> getEmployeeDetails() {
		List<EmployeeBean> listEmployee = new ArrayList<EmployeeBean>(employeeServiceImpl.getAllEmployee());
		
		return new ResponseEntity<List<EmployeeBean>>(listEmployee,HttpStatus.OK);
	}

	@RequestMapping(value = "emp/controller/getDetailsById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> getEmployeeDetailByEmployeeId(@PathVariable("id") int myId) {
		EmployeeBean employee = employeeServiceImpl.getEmployeeDetailsById(myId);

		if (employee != null) {
			return new ResponseEntity<EmployeeBean>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<EmployeeBean>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/emp/controller/addEmp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeBean employee) {
		int count=employeeServiceImpl.addEmployee(employee);
		return new ResponseEntity<String>("Employee added successfully with id:" + count,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/emp/controller/updateEmp", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> updateEmployee(@RequestBody  EmployeeBean employee) {
		if (employeeServiceImpl.getEmployeeDetailsById(employee.getId()) == null) {
			EmployeeBean employee2 = null;
			return new ResponseEntity<EmployeeBean>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		EmployeeBean updated = employeeServiceImpl.updateEmployee(employee);
		return new ResponseEntity<EmployeeBean>(updated, HttpStatus.OK);
	}

	@RequestMapping(value = "/emp/controller/deleteEmp/{id}", method = RequestMethod.DELETE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> deleteEmployee(@PathVariable("id") int myId) {
		EmployeeBean employee2=employeeServiceImpl.getEmployeeDetailsById(myId);
		if (employeeServiceImpl.getEmployeeDetailsById(myId) == null) {
			return new ResponseEntity<EmployeeBean>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		employeeServiceImpl.removeEmployee(myId);
		return new ResponseEntity<EmployeeBean>(employee2, HttpStatus.OK);
	}
}