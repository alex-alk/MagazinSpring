package com.pack.magazin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.pack.magazin.entity.Articol;
import com.pack.magazin.entity.Client;
import com.pack.magazin.factory.JPAEntityFactoryBean;

@Component
public class ClientDAO {
	@Autowired
	JPAEntityFactoryBean entityFactoryBean;
	
	public List<Articol> getClienti(){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Articol> articolQuery = em.createNamedQuery("Articol.findAll", Articol.class);
		articolQuery.setHint("javax.persistence.cache.storeMode", "REFRESH");//development only
		List<Articol> articole = articolQuery.getResultList();
		em.close();
		return articole;
	}
	public Articol getArticolById(int id){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Articol> articolQuery = em.createNamedQuery("Articol.findById", Articol.class);
		articolQuery.setHint("javax.persistence.cache.storeMode", "REFRESH");//development only
		articolQuery.setParameter("id", id);
		Articol articole = articolQuery.getSingleResult();
		em.close();
		return articole;
	}
	public void addClient (Client client) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(client);
		txn.commit();
	}
}
