package com.jdc.project.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.project.dto.EmployeeDto;
import com.jdc.project.entity.Employee;

import com.jdc.project.service.EmpService;




@RestController

@RequestMapping("/api/employees")
public class EmployeeManagementApi {
	

	@Autowired
	private EmpService service;
	
	
	@PostMapping("/save")
	ResponseEntity<Employee> saveEmployee( @RequestBody Employee e){
		
//		service.saveEmployee;
		
		return new ResponseEntity<Employee>( service.saveEmployee(e) , HttpStatus.OK );
		
	}
	
	@GetMapping("/search")
	ResponseEntity< List< Employee > > searchEmployee ( ){
		
		var e = service.searchAll();
		
		return ResponseEntity.ok(e);
	}
	
	@GetMapping("/searchtest")
	ResponseEntity< List< EmployeeDto > > searchEmployeeByDto( ){
		
		var e = service.searchAllTest();
		
		return ResponseEntity.ok(e);
		
	}
	
	
	@PutMapping("/update/{id}")
	ResponseEntity< Employee > updateEmployee ( @RequestBody Employee e , @PathVariable int id){
		
		
		
		return new ResponseEntity<Employee>( service.updateEmployee( e , id ) , HttpStatus.OK );
		
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity< String >deleteEmployee ( @PathVariable int id){
		
		return new ResponseEntity< String >( "Employee have just deleted." , HttpStatus.OK );
	}
		
	
	
}
