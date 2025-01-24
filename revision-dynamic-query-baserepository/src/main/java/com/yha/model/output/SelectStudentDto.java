package com.yha.model.output;

import java.time.LocalDate;

import com.yha.model.entity.Student;
import com.yha.model.entity.Student_;
import com.yha.model.entity.Student.Gender;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record SelectStudentDto(
		
		Long id,
		String name,
		int age,
		Gender gender,
		String phone,
		String email,
		LocalDate dob,
		String department

		
		
		) {
	
	public static void select( CriteriaQuery< SelectStudentDto > cq , Root< Student > root ) {
		
		cq.multiselect(
				
				root.get( Student_.id),
				root.get( Student_.name),
				root.get( Student_.age),
				root.get(  Student_.gender),
				root.get( Student_.phone),
				root.get( Student_.email),
				root.get( Student_.dob),
				root.get( Student_.department).get("name")
				
				);
		
	}

}
