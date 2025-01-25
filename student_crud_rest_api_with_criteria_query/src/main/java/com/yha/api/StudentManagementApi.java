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
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentManagementApi {
	
	private final StudentService studentService;
	
	@GetMapping("/search")
	public ResponseEntity<List< SelectStudentDto >> search(@RequestBody ( required = false) SearchStudentDto searchStudentDto){
		
		if( null == searchStudentDto ) {
            
           searchStudentDto = new SearchStudentDto(null, null, 0);
			
		}
		
		return new ResponseEntity<List<SelectStudentDto>>( studentService.search(searchStudentDto) , HttpStatus.FOUND );
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<Student> save(@RequestBody Student student) {

		return new ResponseEntity<Student>(studentService.save(student), HttpStatus.CREATED);

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@PathVariable long id , @RequestBody Student student) {

		return new ResponseEntity<Student>( studentService.update(id, student), HttpStatus.OK );

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@RequestParam long id) {

		studentService.delete(id);
		return new ResponseEntity<String>("Student deleted", HttpStatus.OK );

	}

}
