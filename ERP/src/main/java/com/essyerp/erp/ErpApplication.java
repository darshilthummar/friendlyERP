package com.essyerp.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
public class ErpApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
			SpringApplication.run(ErpApplication.class, args);
			
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		  return application.sources(ErpApplication.class);
    }
}
