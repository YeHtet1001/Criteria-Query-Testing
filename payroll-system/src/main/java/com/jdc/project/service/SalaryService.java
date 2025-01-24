package com.jdc.project.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.project.entity.Salary;
import com.jdc.project.input.SearchSalaryDto;
import com.jdc.project.output.SelectSalaryDto;
import com.jdc.project.repo.SalaryRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional( readOnly = true)
public class SalaryService {
	
	
	private final SalaryRepo repo ;
	
	
	public List<SelectSalaryDto> searchBy( SearchSalaryDto search){
		
		return repo.search( searchFun (search));
		
	}


	private Function<CriteriaBuilder,CriteriaQuery<SelectSalaryDto>> searchFun(SearchSalaryDto search) {
		
		return cb ->{
			
			
			var cq = cb.createQuery(SelectSalaryDto.class);
			
			var root = cq.from(Salary.class);
			
			SelectSalaryDto.select( cq , root );
			
			cq.where( search.search(cb, cq, root));
			
			return cq;
			
			
		};
		
	}
	

}
