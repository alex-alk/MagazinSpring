package com.pack.magazin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.pack.magazin.entity.Admin;
import com.pack.magazin.factory.JPAEntityFactoryBean;

@Component
public class AdminDAO {
	@Autowired
	JPAEntityFactoryBean entityFactoryBean;
	
	public List<Admin> getAdmins(){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Admin> adminQuery = em.createNamedQuery("Admin.findAll", Admin.class);
		List<Admin> admini = adminQuery.getResultList();
		em.close();
		return admini;
	}
}
