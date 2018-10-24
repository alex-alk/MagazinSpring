package com.pack.magazin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.pack.magazin.entity.Orders;
import com.pack.magazin.factory.JPAEntityFactoryBean;

@Component
public class OrdersDAO {
	@Autowired
	JPAEntityFactoryBean entityFactoryBean;

	public List<Orders> getAllOrders(){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Orders> query = em.createNamedQuery("Orders.findAll", Orders.class);
		List<Orders> orders = query.getResultList();
		em.close();
		return orders;
	}
	public Orders getOrderById(int id){
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Orders> query = em.createNamedQuery("Orders.findById", Orders.class);
		query.setParameter("id", id);
		Orders order = query.getSingleResult();
		em.close();
		return order;
	}
	public void addOrder (Orders order) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(order);
		txn.commit();
	}
	public void deleteOrder (Orders order) {
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		Orders mergedOrder = em.find(Orders.class, order.getId());
		em.remove(mergedOrder);
		txn.commit();
	}
}
