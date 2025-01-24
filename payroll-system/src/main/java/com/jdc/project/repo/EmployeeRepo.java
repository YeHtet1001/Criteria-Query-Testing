package com.jdc.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jdc.project.entity.BaseRespositry;
import com.jdc.project.entity.Employee;

@Repository
public interface EmployeeRepo extends BaseRespositry<Employee, Integer> {
	
	@Query(
			"""
			 select e from Employee e
			""")
	List<Employee> searchAll();

}
