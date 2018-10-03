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
import com.pack.magazin.entity.Articles;
import com.pack.magazin.factory.JPAEntityFactoryBean;
import com.pack.magazin.model.MainQuery;

@Component
public class ArticlesDAO {
	@Autowired
	JPAEntityFactoryBean entityFactoryBean;
	
	public List<Articles> getArticles(int limit){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Articles> articolQuery = em.createNamedQuery("Articles.findAll", Articles.class);
		List<Articles> articles = articolQuery.setMaxResults(limit).getResultList();
		em.close();
		return articles;
	}
	public List<Articles> getAllArticles(){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Articles> articolQuery = em.createNamedQuery("Articles.findAll", Articles.class);
		List<Articles> articles = articolQuery.getResultList();
		em.close();
		return articles;
	}
	public Articles getArticolById(String idstr){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Articles> articolQuery = em.createNamedQuery("Article.findById", Articles.class);
		int id = Integer.parseInt(idstr);
		articolQuery.setParameter("id", id);
		Articles articles = articolQuery.getSingleResult();
		em.close();
		return articles;
	}
	public List<Articles> getArticlesByMainQuery(MainQuery mainQuery){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
			
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Articles> q = cb.createQuery(Articles.class);
		Root<Articles> c = q.from(Articles.class);
		
		if(mainQuery.nothingSelected()){
			q.select(c).where(cb.like(c.get("name"), "%"+mainQuery.getText()+"%"))
			.orderBy(cb.asc(c.get(mainQuery.orderBy())));
		}else {
			q.select(c).where(
					cb.or(
							cb.equal(c.get("category"), mainQuery.getPesti()),
							cb.equal(c.get("category"), mainQuery.getHrana()),
							cb.equal(c.get("category"), mainQuery.getAcv()),
							cb.equal(c.get("category"), mainQuery.getAccesorii())
						 ),cb.like(c.get("name"), "%"+mainQuery.getText()+"%")
			)
			.orderBy(cb.asc(c.get(mainQuery.orderBy())));
		}	
		TypedQuery<Articles> articolQuery = em.createQuery(q)
				.setFirstResult(mainQuery.getOffset())
				.setMaxResults(mainQuery.getLimit());
		List<Articles> articles = articolQuery.getResultList();
		em.close();
		return articles;
	}
	public List<Articles> getAllArticlesByMainQuery(MainQuery mainQuery){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
			
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Articles> q = cb.createQuery(Articles.class);
		Root<Articles> c = q.from(Articles.class);
		
		if(mainQuery.nothingSelected()){
			q.select(c).where(cb.like(c.get("name"), "%"+mainQuery.getText()+"%"))
			.orderBy(cb.asc(c.get(mainQuery.orderBy())));
		}else {
			q.select(c).where(
					cb.or(
							cb.equal(c.get("category"), mainQuery.getPesti()),
							cb.equal(c.get("category"), mainQuery.getHrana()),
							cb.equal(c.get("category"), mainQuery.getAcv()),
							cb.equal(c.get("category"), mainQuery.getAccesorii())
						 ),cb.like(c.get("name"), "%"+mainQuery.getText()+"%")
			)
			.orderBy(cb.asc(c.get(mainQuery.orderBy())));
		}	
		TypedQuery<Articles> articolQuery = em.createQuery(q);
		List<Articles> articles = articolQuery.getResultList();
		em.close();
		return articles;
	}
	public void addArticol (Articles articol) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(articol);
		txn.commit();				
	}
	public void updateArticol (Articles articol) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.merge(articol);
		txn.commit();
	}
	public void deleteArticol (int id) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		Articles articol = em.find(Articles.class, id);
		em.remove(articol);
		txn.commit();
	}
}
