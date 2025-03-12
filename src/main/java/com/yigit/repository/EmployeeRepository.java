package com.yigit.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yigit.model.Employee;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private List<Employee> employeeList;
	
	public List<Employee> getAllEmployeeList(){
		
		return employeeList;
	}
	

}
