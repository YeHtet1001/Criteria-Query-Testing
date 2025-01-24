package com.yha.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table( name = "department_tbl" )
public class Department {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	private String name;
	
	@OneToMany( mappedBy = "department" , cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Student> students ;

}
