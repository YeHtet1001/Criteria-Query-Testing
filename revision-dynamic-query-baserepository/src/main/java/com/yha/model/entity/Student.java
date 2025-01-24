package com.yha.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table( name = "student_tbl" )
public class Student {
	
	public enum Gender{
		Male,Female
	}
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column( nullable = false )
	private String name;
	
	@Column( nullable = false )
	private int age;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column( nullable = false )
	private String phone;
	
	@Column( nullable = false )
	private String email;
	
	@Column( nullable = false )
	private LocalDate dob;
	
	@ManyToOne
	private Department department;

}
