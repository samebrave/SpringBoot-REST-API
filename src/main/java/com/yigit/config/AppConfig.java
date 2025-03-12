package com.yigit.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yigit.model.Employee;

@Configuration
public class AppConfig {

	@Bean
	public List<Employee> employeeList(){
		List<Employee> employeeList = new ArrayList<>();
		
		employeeList.add(new Employee("1", "Yigit", "Yigitto"));
		employeeList.add(new Employee("2", "Yusuf", "Nesiri"));
		employeeList.add(new Employee("3", "Edin", "Dzeko"));
		employeeList.add(new Employee("4", "Ferdi", "Kadioglu"));
		employeeList.add(new Employee("1", "Luis", "Nani"));
		
		return employeeList;
	}
}
