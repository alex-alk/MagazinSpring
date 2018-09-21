package com.pack.magazin.entity;

import javax.annotation.*;
import javax.persistence.*;
import org.springframework.stereotype.*;

@Component
public class JPAEntityFactoryBean {
	EntityManagerFactory entityManagerFactory;
	
	@PostConstruct
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("MagazinSpring");
	}
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
