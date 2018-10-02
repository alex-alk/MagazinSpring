package com.pack.magazin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.pack.magazin.entity.Offers;
import com.pack.magazin.factory.JPAEntityFactoryBean;

@Component
public class OffersDAO {
	@Autowired
	JPAEntityFactoryBean entityFactoryBean;
	
	public List<Offers> getAllOffers(){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Offers> query = em.createNamedQuery("Offers.findAll", Offers.class);
		List<Offers> offers = query.getResultList();
		em.close();
		return offers;
	}
	public Offers getOfferById(int id){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Offers> query = em.createNamedQuery("Offers.findById", Offers.class);
		query.setParameter("id", id);
		Offers offer = query.getSingleResult();
		em.close();
		return offer;
	}
	public void addOffer (Offers offer) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(offer);
		txn.commit();
	}
	public void deleteOffer (Offers offer) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		Offers mergedOffer = em.find(Offers.class, offer.getId());
		em.remove(mergedOffer);
		txn.commit();
	}
}
