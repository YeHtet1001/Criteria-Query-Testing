package com.jdc.project.output;

import com.jdc.project.entity.Department;
import com.jdc.project.entity.Department_;
import com.jdc.project.entity.Employee_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record SelectDepartmentDto(
		
		String department,
		
		Long countEmps
		
		) {
	
	
	public static void select (CriteriaBuilder cb , CriteriaQuery<SelectDepartmentDto> cq , Root< Department> root) {
		
		var join = root.join(Department_.employees);
		
		cq.multiselect(
				
				root.get( Department_.name ),
				
				cb.countDistinct( join.get( Employee_.name ) )
				
				);
		
		cq.groupBy( root.get( Department_.name ) );
		
		
	}

}
