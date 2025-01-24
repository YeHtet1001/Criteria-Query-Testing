package com.jdc.project.output;

import com.jdc.project.entity.Employee_;
import com.jdc.project.entity.Salary;
import com.jdc.project.entity.Salary.Position;
import com.jdc.project.entity.Salary_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record SelectSalaryDto (
		
		String employee,
		double amount,
		double bonus,
		Position position
		
		
		){
	
	
	public static void select( CriteriaQuery< SelectSalaryDto > cq , Root<Salary> root ) {
		
		cq.multiselect(
				
				root.get( Salary_.employee).get( Employee_.name),
				root.get( Salary_.amount),
				root.get( Salary_.bonus),
				root.get( Salary_.position)
				
				
				);
		
	}

}
