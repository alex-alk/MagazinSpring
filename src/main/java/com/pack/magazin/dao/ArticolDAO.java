package com.pack.magazin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.pack.magazin.entity.Articol;
import com.pack.magazin.factory.JPAEntityFactoryBean;

@Component
public class ArticolDAO {
	@Autowired
	JPAEntityFactoryBean entityFactoryBean;
	
	public List<Articol> getArticole(){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Articol> articolQuery = em.createNamedQuery("Articol.findAll", Articol.class);
		List<Articol> articole = articolQuery.getResultList();
		em.close();
		return articole;
	}
	public void addArticol (Articol articol) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(articol);
		txn.commit();
	}
}
