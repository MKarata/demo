package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.deans.Employee;
import com.example.demo.entity.EmployeeDetails;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.services.PracticeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200") //used to allow the request from UI
public class EmployeeController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeRepository employeeRepository; 
	
	@Autowired
	PracticeService practiceService;
	
	/**
	 * used for saving data in DB
	 * @param employees
	 * @return
	 */
	@PostMapping("/employeesInfo")
	public ResponseEntity<EmployeeDetails> saveEmployees(@RequestBody EmployeeDetails employees) {
		return new ResponseEntity<>(employeeRepository.save(employees), HttpStatus.CREATED);
	}
	
	/**
	 * used to get all the data from db
	 * @return
	 */
	@GetMapping("/employeesInfo")
	public ResponseEntity<List<EmployeeDetails>> getAllEmployees() {
		return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
	}
	
	/**
	 * used to get particular employee details from DB
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/employeesInfo/{id}")
	public ResponseEntity<EmployeeDetails> getEmployee(@PathVariable Integer id) {
		Optional<EmployeeDetails> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			return new ResponseEntity<>(emp.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(emp.get(), HttpStatus.NOT_FOUND);

	}
	
	/**
	 * used to update the existing details
	 * 
	 * @param id
	 * @param empDetails
	 * @return
	 */
	@PostMapping("/update/employeesInfo/{id}")
	public ResponseEntity<EmployeeDetails> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDetails empDetails) {
		Optional<EmployeeDetails> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			emp.get().setName(empDetails.getName());
			emp.get().setLocation(empDetails.getLocation());
			emp.get().setPinCode(empDetails.getPinCode());
			return new ResponseEntity<>(employeeRepository.save(emp.get()), HttpStatus.OK);
		}
		return new ResponseEntity<>(emp.get(), HttpStatus.NOT_FOUND);

	}
	
	/**
	 * used to for deleting particular row/id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/employeesInfo/{id}")
	public ResponseEntity<EmployeeDetails> deleteEmployee(@PathVariable Integer id) {
		Optional<EmployeeDetails> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			employeeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(emp.get(), HttpStatus.NOT_FOUND);

	}
	
	/**
	 * @return
	 */
	@GetMapping("/employees/high-salary")
	public List<Employee> getHighestSalary() {
		return practiceService.getHighestSalarys();
	}
	
	
}
