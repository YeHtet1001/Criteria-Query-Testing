package com.jdc.project.output;

import java.time.LocalDate;

import com.jdc.project.entity.Department_;
import com.jdc.project.entity.Employee;
import com.jdc.project.entity.Employee_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record SelectEmployeeDto(
		
		int id,
		String employee,
		LocalDate dob,
		String department
		
		) {
	
	public static void select( CriteriaQuery< SelectEmployeeDto > cq , Root< Employee > root ) {
		
		cq.multiselect(
				
				root.get(Employee_.id),
				root.get(Employee_.name),
				root.get(Employee_.dob),
				root.get(Employee_.department).get(Department_.name)
				
				);
//		cq.orderBy( Order.asc( root.get(Employee_.name) ) );
		
	}
	
}
