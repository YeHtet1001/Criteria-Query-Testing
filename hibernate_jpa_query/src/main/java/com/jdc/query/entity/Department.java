package com.jdc.query.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
//	@Column( name = "emp_id" )
	private int id;
	
	@Column( nullable = false , length =45 )
	private String name;
	
	@ColumnDefault( "1" )
//	@Column( name = "empActive" )
	private boolean active;
	
	@OneToMany( mappedBy = "department", cascade = CascadeType.PERSIST , orphanRemoval = true )
	private List<Employee> employees ;
	
}
