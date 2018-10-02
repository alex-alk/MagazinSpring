package com.pack.magazin.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comenzi database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Orders.findAll", query="SELECT o FROM Orders o"),
	@NamedQuery(name="Orders.findById", query = "SELECT o FROM Orders o WHERE o.id=:id")
})
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="articles_id")
	private int articlesId;

	private int quantity;

	@Column(name="client_id")
	private int clientId;

	@Id
	private int id;

	public Orders() {
	}

	public int getArticlesId() {
		return this.articlesId;
	}

	public void setArticlesId(int articlesId) {
		this.articlesId = articlesId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getClientiId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}