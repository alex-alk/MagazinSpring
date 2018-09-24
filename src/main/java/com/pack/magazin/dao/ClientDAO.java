package com.pack.magazin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.pack.magazin.entity.Articole;
import com.pack.magazin.entity.Clienti;
import com.pack.magazin.factory.JPAEntityFactoryBean;

@Component
public class ClientDAO {
	@Autowired
	JPAEntityFactoryBean entityFactoryBean;
	
	public List<Articole> getClienti(){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Articole> articolQuery = em.createNamedQuery("Articol.findAll", Articole.class);
		articolQuery.setHint("javax.persistence.cache.storeMode", "REFRESH");//development only
		List<Articole> articole = articolQuery.getResultList();
		em.close();
		return articole;
	}
	public Articole getArticolById(int id){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Articole> articolQuery = em.createNamedQuery("Articol.findById", Articole.class);
		articolQuery.setHint("javax.persistence.cache.storeMode", "REFRESH");//development only
		articolQuery.setParameter("id", id);
		Articole articole = articolQuery.getSingleResult();
		em.close();
		return articole;
	}
	public void addClient (Clienti client) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(client);
		txn.commit();
	}
}
