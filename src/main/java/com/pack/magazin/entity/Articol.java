package com.pack.magazin.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the articol database table.
 * 
 */
@Entity
@NamedQuery(name="Articol.findAll", query="SELECT a FROM Articol a")
public class Articol implements Serializable {
	private static final long serialVersionUID = 1L;
	private String categorie;
	private String descriere;
	private int id;
	private String imagineURL;
	private String nume;
	private int pret;

	public Articol() {
	}


	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	@Lob
	public String getDescriere() {
		return this.descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getImagineURL() {
		return this.imagineURL;
	}

	public void setImagineURL(String imagineURL) {
		this.imagineURL = imagineURL;
	}


	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}


	public int getPret() {
		return this.pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}

}