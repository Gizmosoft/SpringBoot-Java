package com.accenture.lkm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.service.EmployeeService;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	
	
	@RequestMapping(value = "/employee/{id}", 
					produces = { "application/json", "application/xml" }, 
					method = RequestMethod.GET)
	public EmployeeBean getEmployeeById(@PathVariable("id") Integer id) {
		return employeeService.getEmployeeDetailsById(id);
	}
}
