package com.pack.magazin.model;

import org.springframework.stereotype.Component;

@Component
public class MainQuery {
	private String text;
	private String pesti;
	private String hrana;
	private String accesorii;
	private String acv;
	private String den;
	private String pret;
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
	public String getDen() {
		return den;
	}
	public void setDen(String den) {
		this.den = den;
	}
	public String getPret() {
		return pret;
	}
	public void setPret(String pret) {
		this.pret = pret;
	}
	public String getPesti() {
		return pesti;
	}
	public void setPesti(String pesti) {
		this.pesti = pesti;
	}
}
