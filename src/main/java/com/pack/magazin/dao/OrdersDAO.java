package com.pack.magazin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.pack.magazin.entity.Clients;
import com.pack.magazin.entity.Orders;
import com.pack.magazin.factory.JPAEntityFactoryBean;

@Component
public class OrdersDAO {
	@Autowired
	JPAEntityFactoryBean entityFactoryBean;
	/*
	public List<Comenzi> getComenzi(){
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
		
		TypedQuery<Clienti> query = em.createNamedQuery("Clienti.findByEmail", Clienti.class);
		query.setParameter("email", email);
		Clienti client;
		try {
			client = query.getSingleResult();
		}catch(Exception e){
			client = new Clienti();
		}
		em.close();
		return client;
	}/*
	public Clienti getClientById(int id){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Clienti> query = em.createNamedQuery("Clienti.findById", Clienti.class);
		query.setParameter("id", id);
		Clienti client = query.getSingleResult();
		em.close();
		return client;
	}*/
	public void addOrder (Orders order) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(order);
		txn.commit();
	}
}
