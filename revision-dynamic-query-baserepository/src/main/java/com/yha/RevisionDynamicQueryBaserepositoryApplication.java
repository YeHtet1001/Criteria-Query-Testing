package com.yha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.yha.model.BaseRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories( repositoryBaseClass = BaseRepositoryImpl.class )
public class RevisionDynamicQueryBaserepositoryApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(RevisionDynamicQueryBaserepositoryApplication.class, args);
		
	}

}
