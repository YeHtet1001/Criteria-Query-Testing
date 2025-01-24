package com.jdc.project.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table( name = "leave_tbl" )
public class Leave {
	
	public enum LeaveType{
		
		Annual, Paid , Medical
		
	}
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate fromDt;
	private LocalDate toDt;
	private String reasons;
	
	@Enumerated( EnumType.STRING )
	private LeaveType leaveType;
	
	

}
