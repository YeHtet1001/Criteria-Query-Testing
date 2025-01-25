package com.yha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.yha.model.BaseRepositoryImp;

@SpringBootApplication
@EnableJpaRepositories( repositoryBaseClass = BaseRepositoryImp.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
