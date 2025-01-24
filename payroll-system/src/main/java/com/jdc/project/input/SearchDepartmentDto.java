package com.jdc.project.input;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.project.entity.Department;
import com.jdc.project.entity.Department_;
import com.jdc.project.entity.Employee_;
import com.jdc.project.output.SelectDepartmentDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record SearchDepartmentDto(
		
		String keyword
		
		) {

	
	public Predicate[] search ( CriteriaBuilder cb , CriteriaQuery<SelectDepartmentDto> cq , Root<Department> root ) {
		
		var params = new ArrayList<Predicate>();
		
		
		if( StringUtils.hasLength( keyword ) ) {
			
			var join = root.join(Department_.employees);
			
			cb.or(
					
					cb.equal( root.get(Department_.name), keyword.toLowerCase()),
					cb.like(cb.lower(join.get(Employee_.name)), keyword.toLowerCase().concat("%"))
					
				);
			
		}
		
		return params.toArray( size -> new Predicate[size]);
		
	}
	
}
