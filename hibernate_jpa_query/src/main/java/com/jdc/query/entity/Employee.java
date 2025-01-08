package com.jdc.query.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table( name = "employee_tbl" )
public class Employee {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column( nullable = false , length =45)
	private String name;
	
	private LocalDate dob;
	
	@ColumnDefault("1")
	private boolean active;
	
	@ManyToOne
	private Department department;
	
	public String toString() {
		
		return name;
		
	}

	
}
