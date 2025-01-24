package com.jdc.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.project.input.SearchEmployeeDto;
import com.jdc.project.service.EmpService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EmployeeTests {
	
	
	@Autowired
	private EmpService service;
	
	

	@Order(1)
	@ParameterizedTest
	@CsvSource({
		
		"j,,,,,3",
		",IT,,,,2",
		
		
		
	})
	void search(
			
			String employee,
			String department,
			Boolean active,
			LocalDate  from,
			LocalDate to,
			int res
			
			) {
		
		var search = new SearchEmployeeDto(employee, department, active, from, to);
		
		var list = service.search( search);
		
		assertEquals( res , list.size() );
		
		System.out.println( "list :" + list );
		
	}

}
