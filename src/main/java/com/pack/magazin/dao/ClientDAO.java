package com.pack.magazin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.pack.magazin.entity.Clienti;
import com.pack.magazin.factory.JPAEntityFactoryBean;

@Component
public class ClientDAO {
	@Autowired
	JPAEntityFactoryBean entityFactoryBean;
	
	public List<Clienti> getClienti(){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Clienti> query = em.createNamedQuery("Clienti.findAll", Clienti.class);
		List<Clienti> Clienti = query.getResultList();
		em.close();
		return Clienti;
	}
	public Clienti getClientByEmail(String email){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Clienti> query = em.createNamedQuery("Clienti.findById", Clienti.class);
		query.setParameter("email", email);
		Clienti Clienti = query.getSingleResult();
		em.close();
		return Clienti;
	}
	/*
	public Clienti getClientById(int id){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Clienti> articolQuery = em.createNamedQuery("Articol.findById", Clienti.class);
		articolQuery.setHint("javax.persistence.cache.storeMode", "REFRESH");//development only
		articolQuery.setParameter("id", id);
		Clienti Clienti = articolQuery.getSingleResult();
		em.close();
		return Clienti;
	}*/
	public void addClient (Clienti client) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(client);
		txn.commit();
	}
}
