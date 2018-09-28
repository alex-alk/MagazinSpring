package com.pack.magazin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.pack.magazin.entity.Clients;
import com.pack.magazin.factory.JPAEntityFactoryBean;

@Component
public class ClientsDAO {
	@Autowired
	JPAEntityFactoryBean entityFactoryBean;
	
	public List<Clients> getClients(){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Clients> query = em.createNamedQuery("Clients.findAll", Clients.class);
		List<Clients> Clients = query.getResultList();
		em.close();
		return Clients;
	}
	public Clients getClientByEmail(String email){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Clients> query = em.createNamedQuery("Clients.findByEmail", Clients.class);
		query.setParameter("email", email);
		Clients client;
		try {
			client = query.getSingleResult();
		}catch(Exception e){
			client = new Clients();
		}
		em.close();
		return client;
	}/*
	public Clients getClientById(int id){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Clients> query = em.createNamedQuery("Clients.findById", Clients.class);
		query.setParameter("id", id);
		Clients client = query.getSingleResult();
		em.close();
		return client;
	}*/
	public void addClient (Clients client) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(client);
		txn.commit();
	}
}
