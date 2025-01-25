package com.yha.model.entity;

import com.yha.model.consts.Gender;

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
@Table(name = "student_tbl")
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column( nullable = false )
	private String name;
	
	@Column( nullable = false )
	private int age;
	
	@Column( nullable = false )
	private String email;
	
	@Column( nullable = false )
	private String phone;
	
	@Enumerated( EnumType.STRING )
	private Gender gender;
	
	@ManyToOne
	private Department department;

}
