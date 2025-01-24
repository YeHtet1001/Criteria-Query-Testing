package com.jdc.project.input;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.project.entity.Employee_;
import com.jdc.project.entity.Salary;
import com.jdc.project.entity.Salary_;
import com.jdc.project.output.SelectSalaryDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record SearchSalaryDto(
		
		double amount,
		String employee
		
		) {
	
	public Predicate[] search( CriteriaBuilder cb, CriteriaQuery<SelectSalaryDto> cq , Root<Salary> root ) {
		
		var params = new ArrayList<Predicate>();
		
		if( StringUtils.hasLength(employee)) {
			
			params.add(
					
					cb.equal(root.get( Salary_.employee).get(Employee_.name), employee)
					
					);
			
			
		}
		
		
		
		return params.toArray( size -> new Predicate[ size ] ); 
	}
	

}
