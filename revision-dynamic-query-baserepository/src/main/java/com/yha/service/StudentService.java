package com.yha.service;


import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yha.model.entity.Student;
import com.yha.model.input.SearchStudentDto;
import com.yha.model.output.SelectStudentDto;
import com.yha.model.repo.StudentRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional( readOnly = true )
public class StudentService {
	
	private final StudentRepo repo;
	
	public List<SelectStudentDto> search(SearchStudentDto search) {

		return repo.search( searchFun( search ) );

	}
	
	
	public Function< CriteriaBuilder , CriteriaQuery< SelectStudentDto >> searchFun ( SearchStudentDto search ){
		
		return cb ->{
			
			var cq = cb.createQuery( SelectStudentDto.class );
			var root = cq.from( Student.class );
			
			SelectStudentDto.select( cq , root ); 
			
			cq.where( search.search( cb , cq , root ) );
			
			return cq;
			
		};
	
		
	}
	
	@Transactional
	public Student save( Student student ) {

		return repo.save(student);

	}
	
	@Transactional
	public Student update( Student student , long id ) {
		
		var updatedStudent = repo.findById( id ).orElseThrow( () -> new NullPointerException( "There is no entity for that id." ) );
		
		updatedStudent.setName( student.getName() );
		updatedStudent.setAge( student.getAge() );
		updatedStudent.setEmail( student.getEmail() );
		updatedStudent.setPhone( student.getPhone() );
		updatedStudent.setDepartment( student.getDepartment() );
		updatedStudent.setDob( student.getDob() );
		
		
		return repo.save( updatedStudent );
		
	}
	
	@Transactional
	public void delete(long id) {

		var student = repo.findById( id ).orElseThrow( () -> new NullPointerException( "There is no entity for that id." ) );

		repo.delete(student);

	}
        
	
}
