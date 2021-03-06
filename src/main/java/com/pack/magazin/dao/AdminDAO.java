package com.pack.magazin.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.pack.magazin.entity.Admin;
import com.pack.magazin.factory.JPAEntityFactoryBean;

@Component
public class AdminDAO {
	@Autowired
	JPAEntityFactoryBean entityFactoryBean;
	
	public Admin getAdmin(){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Admin> adminQuery = em.createNamedQuery("Admin.findAll", Admin.class);
		Admin admin = adminQuery.getSingleResult();
		em.close();
		return admin;
	}
}
