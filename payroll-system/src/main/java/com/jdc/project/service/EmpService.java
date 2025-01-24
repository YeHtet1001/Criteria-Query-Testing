package com.jdc.project.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.project.dto.EmployeeDto;
import com.jdc.project.entity.Employee;
import com.jdc.project.input.SearchEmployeeDto;
import com.jdc.project.output.SelectEmployeeDto;
import com.jdc.project.repo.EmployeeRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;


@Service
@Transactional( readOnly =true )
public class EmpService {
	
	@Autowired
	private EmployeeRepo repo ;
	
	@Transactional
	public Employee saveEmployee( Employee e ) {
		
		return repo.save( e );
		
	}
	
	@Transactional
	public Employee updateEmployee( Employee e  , int id ) {
		
		var opt = repo.findById( id );
		
		var emp = opt.orElseThrow();
		
		emp.setName( e.getName() );
		emp.setDob( e.getDob() );
		emp.setDepartment( e.getDepartment() );
		emp.setActive( e.isActive() );
		
		return repo.save(emp);
		
	}
	
	@Transactional
	public void deleteEmployee( int id ) {
		
		var opt = repo.findById( id );
		
		var emp = opt.orElseThrow( () -> new NullPointerException(" There is no entity for that id."));
		
		repo.delete( emp );
		
	}
	
	
	public List< SelectEmployeeDto > search ( SearchEmployeeDto search ){
		
		
		return repo.search( searchFun(search) );
		
	}

	private Function< CriteriaBuilder , CriteriaQuery< SelectEmployeeDto > > 
	searchFun( SearchEmployeeDto search ) {
		
		Function< CriteriaBuilder , CriteriaQuery< SelectEmployeeDto > >  fun  = cb -> {
			
			var cq = cb.createQuery( SelectEmployeeDto.class );
			
			var root = cq.from( Employee.class );
			
			SelectEmployeeDto.select( cq , root );
			
			cq.where( search.search( cb , cq , root ) );
			
			return cq;
			
		};
		
		return fun;
		
	}
	
	public List<EmployeeDto> searchAllTest(){
		
		return repo.findAll().stream()
				.map ( e -> new EmployeeDto(
						e.getId(),
						e.getName(),
						e.getDob(),
						e.isActive(),
						e.getDepartment() != null ? e.getDepartment().getId() : null
						))
				.collect(Collectors.toList());
		
	}

	public List<Employee> searchAll(){
		
		return repo.findAll();
		
	}
	
}
