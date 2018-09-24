package com.pack.magazin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.pack.magazin.entity.Articole;
import com.pack.magazin.factory.JPAEntityFactoryBean;
import com.pack.magazin.model.MainQuery;

@Component
public class ArticolDAO {
	@Autowired
	private JPAEntityFactoryBean entityFactoryBean;
	
	public List<Articole> getArticole(){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Articole> articolQuery = em.createNamedQuery("Articole.findAll", Articole.class);
		articolQuery.setHint("javax.persistence.cache.storeMode", "REFRESH");//development only
		List<Articole> articole = articolQuery.getResultList();
		em.close();
		return articole;
	}
	public Articole getArticolById(int id){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Articole> articolQuery = em.createNamedQuery("Articole.findById", Articole.class);
		articolQuery.setHint("javax.persistence.cache.storeMode", "REFRESH");//development only
		articolQuery.setParameter("id", id);
		Articole articole = articolQuery.getSingleResult();
		em.close();
		return articole;
	}
	public List<Articole> getArticoleByQueryModel(MainQuery mainQuery){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Articole> articolQuery = em.createNamedQuery("Articole.findByQuery", Articole.class);
		articolQuery.setHint("javax.persistence.cache.storeMode", "REFRESH");//development only
		articolQuery.setParameter("pesti", mainQuery.getPesti());
		articolQuery.setParameter("hrana", mainQuery.getHrana());
		articolQuery.setParameter("accesorii", mainQuery.getAccesorii());
		articolQuery.setParameter("acvarii", mainQuery.getAcv());
		List<Articole> articole = articolQuery.getResultList();
		em.close();
		return articole;
	}
	public List<Articole> getArticoleByOrder(MainQuery mainQuery){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
			
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Articole> q = cb.createQuery(Articole.class);
		Root<Articole> c = q.from(Articole.class);
		q.select(c).orderBy(cb.asc(c.get(mainQuery.getOrder())));
		TypedQuery<Articole> articolQuery = em.createQuery(q);
		articolQuery.setHint("javax.persistence.cache.storeMode", "REFRESH");//development only
		List<Articole> articole = articolQuery.getResultList();
		em.close();
		return articole;
	}
	public void addArticol (Articole articol) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(articol);
		txn.commit();
	}
}
