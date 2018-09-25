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
	JPAEntityFactoryBean entityFactoryBean;
	
	public List<Articole> getArticole(){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Articole> articolQuery = em.createNamedQuery("Articole.findAll", Articole.class);
		//articolQuery.setHint("javax.persistence.cache.storeMode", "REFRESH");//development only
		List<Articole> articole = articolQuery.getResultList();
		em.close();
		return articole;
	}
	public Articole getArticolById(String idstr){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Articole> articolQuery = em.createNamedQuery("Articole.findById", Articole.class);
		//articolQuery.setHint("javax.persistence.cache.storeMode", "REFRESH");//development only
		int id = Integer.parseInt(idstr);
		articolQuery.setParameter("id", id);
		Articole articole = articolQuery.getSingleResult();
		em.close();
		return articole;
	}
	public List<Articole> getArticoleByMainQuery(MainQuery mainQuery){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
			
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Articole> q = cb.createQuery(Articole.class);
		Root<Articole> c = q.from(Articole.class);
		
		if(mainQuery.nothingSelected()){
			q.select(c).orderBy(cb.asc(c.get(mainQuery.orderBy())));
		}else {
			q.select(c).where(
					cb.or(
							cb.equal(c.get("categorie"), mainQuery.getPesti()),
							cb.equal(c.get("categorie"), mainQuery.getHrana()),
							cb.equal(c.get("categorie"), mainQuery.getAcv()),
							cb.equal(c.get("categorie"), mainQuery.getAccesorii())
						 )
			).orderBy(cb.asc(c.get(mainQuery.orderBy())));
		}
		
		TypedQuery<Articole> articolQuery = em.createQuery(q);
		//articolQuery.setHint("javax.persistence.cache.storeMode", "REFRESH");//development only
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
	public void updateArticol (Articole articol) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.merge(articol);
		txn.commit();
	}
}
