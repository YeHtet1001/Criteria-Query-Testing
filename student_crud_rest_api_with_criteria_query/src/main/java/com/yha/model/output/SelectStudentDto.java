package com.yha.model.output;



import com.yha.model.consts.Gender;
import com.yha.model.entity.Department_;
import com.yha.model.entity.Student;
import com.yha.model.entity.Student_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record SelectStudentDto(
		
		String name,
		String department,
		int age,
		String email,
		String phone,
		Gender gender
		
		) {
	
	
	public static void  select( CriteriaQuery<SelectStudentDto> cq , Root<Student> root) {
		
		cq.multiselect(
				
                root.get( Student_.name ),
                root.get( Student_.department).get( Department_.name ),
                root.get( Student_.age ),
                root.get( Student_.email ),
                root.get( Student_.phone ),
                root.get( Student_.gender )
                
        );
		
	}
	

}
