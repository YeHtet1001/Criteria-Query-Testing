package com.jdc.project.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.jdc.project.entity.Department;
import com.jdc.project.entity.Department_;
import com.jdc.project.input.SearchDepartmentDto;
import com.jdc.project.output.SelectDepartmentDto;
import com.jdc.project.repo.DepartmentRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
public class DepService {
	
	@Autowired
	private DepartmentRepository repo;
	
	
	public List<SelectDepartmentDto> search ( SearchDepartmentDto search ){
		
		return repo.search( searchFun (search) );
		
	}


	private Function<CriteriaBuilder,CriteriaQuery<SelectDepartmentDto>> searchFun(SearchDepartmentDto search) {
		// TODO Auto-generated method stub
		return cb -> {
			
			var cq  = cb.createQuery(SelectDepartmentDto.class);
			var root = cq.from( Department.class );
			
			SelectDepartmentDto.select(cb, cq, root);
			
			cq.where( search.search(cb, cq, root));
			
//			cq.orderBy( Order.asc("name)).getOrderList();
			
			return cq;
		};
		
	}
	
	public List<Department> searchAll(){
		
		return repo.findAll();
		
	}

}
