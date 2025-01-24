package com.jdc.query.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.query.entity.Employee;

public class FindAllQueryTest extends JpaEmfFactory {
	
	@Test
	@Order(1)
	void findWithNativeQueryTest() {
		
		var query = em.createNativeQuery("select * from employee_tbl", Employee.class);
		System.out.println( query.getResultList() );
		
		
	}
	
	@Test
	@Order(2)
	void findWithJpalQueryTest() {
		
		var query = em.createQuery("select e from Employee e",Employee.class);
		
		System.out.println( query.getResultList() );
		
		
		
	}
	
	@Test
	@Order(3)
	void findWithCriteriaQueryTest() {
		
		
		var cb = emf.getCriteriaBuilder();
		
		var cq = cb.createQuery(Employee.class);
		
		var root = cq.from(Employee.class);
		
		cq.select(root);
		
		var query = em.createQuery(cq);
		
		System.out.println( query.getResultList() );
		
		
	}
	

}
