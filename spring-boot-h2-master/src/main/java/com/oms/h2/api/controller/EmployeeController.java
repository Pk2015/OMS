package com.oms.h2.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.h2.api.dao.EmployeeRepository;
import com.oms.h2.api.dao.UserRepository;
import com.oms.h2.api.model.Employee;
import com.oms.h2.api.model.UserResponse;

@RestController
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepository repository;
	
	
	@Autowired
	private UserRepository client;
	
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody Employee employee) {
		repository.save(employee);
		return "Employee saved..";
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAll() {
		return repository.findAll();
	}
	

	@GetMapping("/getEmployee/{dept}")	
	public List<Employee> getEmployeesByDept(@PathVariable String dept) {
		return repository.findByDept(dept);
	}

	
	
	/**
	 * feign Client Application , 
	 * had demonstrated the feign  application , could not understand the use case of this.
	 * @return
	 */
	@GetMapping("/getAll")	
	public List<UserResponse> getAllUser() {
		return client.getUsers();
	}

}
