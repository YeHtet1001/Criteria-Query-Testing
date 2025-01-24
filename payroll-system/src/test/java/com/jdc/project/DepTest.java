package com.jdc.project;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.project.input.SearchDepartmentDto;
import com.jdc.project.service.DepService;

@SpringBootTest
@TestMethodOrder( OrderAnnotation.class )
public class DepTest {
	
	@Autowired
	private DepService service;
	
	@Order(1)
	@ParameterizedTest
	@CsvSource(
			{
				"j,1"
			}
			)
	void search( String keyword , int res) {
		
		var list = service.search( new SearchDepartmentDto(keyword) );
		
		System.out.println(list);
		
		
	}

}
