package com.yha.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yha.model.entity.Student;
import com.yha.model.input.SearchStudentDto;
import com.yha.model.output.SelectStudentDto;
import com.yha.model.repo.DepartmentRepository;
import com.yha.model.repo.StudentRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional( readOnly = true )
public class StudentService {
	
	private final StudentRepository studentRepository;
	private final DepartmentRepository departmentRepository;
	
	@Transactional
	public Student save(Student student) {
		
		var depId = departmentRepository.findById(student.getDepartment().getId()).orElseThrow( () -> new NullPointerException("Department not found"));
		student.setDepartment(depId);
		return studentRepository.save(student);
		
	}
	
	@Transactional
	public Student update( long id , Student student ) {
		
		var studentUpdate = studentRepository.findById(id).orElseThrow( () -> new NullPointerException("Student not found") );
		
		studentUpdate.setName(null != student.getName() ? student.getName() : studentUpdate.getName() );
		studentUpdate.setAge( 0 != student.getAge() ? student.getAge() : studentUpdate.getAge() );
		studentUpdate.setEmail( null != student.getEmail() ? student.getEmail() : studentUpdate.getEmail() );
		studentUpdate.setPhone( null != student.getPhone() ? student.getPhone() : studentUpdate.getEmail() );
		studentUpdate.setGender(null != student.getGender() ? student.getGender() : studentUpdate.getGender() );
		studentUpdate.setDepartment( null != student.getDepartment() ? student.getDepartment() : studentUpdate.getDepartment() );
		
		
		return studentRepository.save(studentUpdate) ;
		
	}
        
	@Transactional
	public void delete ( long id ) {
		
		var deleteStudent = studentRepository.findById(id).orElseThrow( () -> new NullPointerException("Student not found") );
		
		studentRepository.delete(deleteStudent);
		
		
	}
	
	
	public List<SelectStudentDto> search(SearchStudentDto searchDto) {

		return studentRepository.search(searchFun(searchDto));

	}

	private Function<CriteriaBuilder, CriteriaQuery<SelectStudentDto>> searchFun( SearchStudentDto searchDto ) {
		// TODO Auto-generated method stub
		return cb ->{
			
			var cq = cb.createQuery(SelectStudentDto.class);
			var root = cq.from(Student.class);
			
			SelectStudentDto.select(cq, root);
			searchDto.search(cb, cq, root);
			
			return cq;
			
		};
	}
	
	
        

}
