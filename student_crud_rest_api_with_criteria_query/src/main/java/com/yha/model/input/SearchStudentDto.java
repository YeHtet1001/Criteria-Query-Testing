package com.yha.model.input;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.yha.model.entity.Student;
import com.yha.model.entity.Student_;
import com.yha.model.output.SelectStudentDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record SearchStudentDto(
		
		String keyword,
		String department,
		int age
		
		) {
	
			public Predicate[] search ( CriteriaBuilder cb , CriteriaQuery<SelectStudentDto> cq , Root<Student> root ) {
				
				var params = new ArrayList<Predicate>();
				
				if (StringUtils.hasLength(keyword)) {

					params.add(
							cb.like( cb.lower( root.get( Student_.name ) ), keyword.toLowerCase().concat("%") )

					);

				}
				
				if (StringUtils.hasLength(department)) {

					params.add(
							
						cb.equal( root.get( Student_.department).get("name") , department )	

					);

				}
				
				if( 0 != age) {
					
					params.add(
							
						cb.or(
								
								cb.equal( root.get( Student_.age ) , age ),
								cb.greaterThanOrEqualTo( root.get(Student_.age), age)
								
								)	
							
							);
					
					
				}
				
				return params.toArray( new Predicate [ params.size() ] );
        
    }
	

}
