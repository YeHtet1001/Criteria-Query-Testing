package com.jdc.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jdc.project.entity.BaseRepoImpl;

@SpringBootApplication
@EnableJpaRepositories( repositoryBaseClass = BaseRepoImpl.class )
public class SpringBootSalaryProjectApplication {

	public static void main( String[] args ) {
		SpringApplication.run(SpringBootSalaryProjectApplication.class, args);
	}

}
