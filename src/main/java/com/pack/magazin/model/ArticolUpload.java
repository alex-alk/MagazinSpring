package com.pack.magazin.model;

import org.springframework.stereotype.Component;

@Component
public class ArticolUpload {
	private String nume;
	private int pret;
	private String categorie;
	private String descriere;
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
}
