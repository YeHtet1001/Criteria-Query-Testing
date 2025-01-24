package com.yha.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yha.model.entity.Student;
import com.yha.model.input.SearchStudentDto;
import com.yha.model.output.SelectStudentDto;
import com.yha.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentApi {
	
	private final StudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent( @RequestBody Student s ) {

		return new ResponseEntity<Student>( service.save(s), HttpStatus.CREATED );

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student s , @PathVariable long id ) {
		
		return new ResponseEntity<Student>( service.update( s , id ), HttpStatus.CREATED );

	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteStudent(@RequestParam long id) {

		service.delete(id);
		
		return new ResponseEntity<String>("Student deleted", HttpStatus.OK);

	}

	@GetMapping("/search")
	public ResponseEntity< List< SelectStudentDto > > search( @RequestBody( required = false ) SearchStudentDto search ) {
		
		if ( null == search ) {
			
			search = new SearchStudentDto( null , null , 0 );
			
		}

		return new ResponseEntity< List< SelectStudentDto > >( service.search( search ) , HttpStatus.FOUND );
		
	}
}
