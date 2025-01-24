package com.jdc.project.dto;

import java.time.LocalDate;

import com.jdc.project.entity.Department;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {
	
	
	private int id;
	
	private String name;
	
	private LocalDate dob;
	
	private boolean active;
	
	private int departmentId;
	
	public EmployeeDto( int id , String name , LocalDate dob , Boolean active , int departmentId ) {
		this.id = id;
		this.name = name ;
		this.dob = dob;
		this.active = active;
		this.departmentId=departmentId;
		
	}

}
