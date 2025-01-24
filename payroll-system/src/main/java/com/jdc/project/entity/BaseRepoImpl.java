package com.jdc.project.entity;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;


public class BaseRepoImpl<T,ID> extends SimpleJpaRepository<T, ID> implements BaseRespositry<T, ID> {
	
	private EntityManager entity;

	public BaseRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		
		super(entityInformation, entityManager);
		this.entity = entityManager;
		
	}

	@Override
	public <R> List<R> search( Function< CriteriaBuilder , CriteriaQuery< R > > queryFun ) {
		
		return entity.createQuery( queryFun.apply( entity.getCriteriaBuilder() ) ).getResultList();
		
	}

}
