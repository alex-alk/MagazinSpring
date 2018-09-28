package com.pack.magazin.model;

import org.springframework.stereotype.Component;

public class OrdersForm {
	
	private String articleId;
	private String quantity;
	private String clientId;
	
	public OrdersForm() {
		clientId = "gol";
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
}
