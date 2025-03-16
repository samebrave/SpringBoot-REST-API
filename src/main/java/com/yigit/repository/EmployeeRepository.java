package com.yigit.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yigit.model.Employee;
import com.yigit.model.UpdateEmployeeRequest;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private List<Employee> employeeList;
	
	public List<Employee> getAllEmployeeList(){
		
		return employeeList;
	}
	
	public Employee getEmployeeById(String id) {
		Employee findEmployee = null;
		
		for (Employee employee : employeeList) {
			if(id.equals(employee.getId())) {
				findEmployee = employee;
				break;
			}
				
		}
		
		return findEmployee;
	}
	
	public List<Employee> getEmployeeWithParams(String firstName, String lastName){
		List<Employee> employeeWithParams = new ArrayList<>();
		
		if(firstName == null && lastName == null) {
			return employeeList;
		}
		
		for (Employee employee : employeeList) {
			if(firstName != null && lastName != null) {
				if(employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);
				}
			}
			
			if(firstName != null && lastName == null) {
				if(employee.getFirstName().equalsIgnoreCase(firstName)) {
					employeeWithParams.add(employee);
				}
			}
			
			if(firstName == null && lastName != null) {
				if (employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);
					
				}
			}
			
		}
		
		return employeeWithParams;
	}
	
	
	public Employee saveEmployee (Employee newEmployee) {
		employeeList.add(newEmployee);
		return newEmployee;	
	}
	
	public boolean deleteEmployee (String id) {
		Employee deleteEmployee = null;
		for (Employee employee : employeeList) {
			if(id.equals(employee.getId())) {
				deleteEmployee = employee;
				break;
			}
		}
		if(deleteEmployee == null){
			return false;
		}
		employeeList.remove(deleteEmployee);
		return true;
	}
	
	public Employee updateEmployee(String id, UpdateEmployeeRequest updateEmployee) {
	    Employee updatedEmployee = null;

	    for (Employee employee : employeeList) {
	        if (id.equals(employee.getId())) {
	            employee.setFirstName(updateEmployee.getFirstName());
	            employee.setLastName(updateEmployee.getLastName());
	            updatedEmployee = employee;
	            break;
	        }
	    }

	    return updatedEmployee;
	}

	
	
	

}
