package com.pack.magazin.model;

import org.springframework.stereotype.Component;

@Component
public class MainQuery {
	private String text;
	private String pesti;
	private String hrana;
	private String accesorii;
	private String acv;
	private String order;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getHrana() {
		return hrana;
	}
	public void setHrana(String hrana) {
		this.hrana = hrana;
	}
	public String getAccesorii() {
		return accesorii;
	}
	public void setAccesorii(String accesorii) {
		this.accesorii = accesorii;
	}
	public String getAcv() {
		return acv;
	}
	public void setAcv(String acv) {
		this.acv = acv;
	}
	public String getPesti() {
		return pesti;
	}
	public void setPesti(String pesti) {
		this.pesti = pesti;
	}
	public boolean nothingSelected() {
		if(pesti==null&&hrana==null&&acv==null&&accesorii==null)return true;return false;
	}
	public String orderBy() {
		if(order.equals("pret"))return "pret";
		else if(order.equals("nume"))return "nume";
		else return "id";
	}
	public boolean isOrderSelected() {
		if(order==null)return false; return true;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
}
