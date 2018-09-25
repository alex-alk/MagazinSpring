package com.pack.magazin.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;


/**
 * The persistent class for the articol database table.
 * 
 */
@Component
@Entity
@NamedQueries({
	@NamedQuery(name="Articole.findAll", query="SELECT a FROM Articole a"),
	@NamedQuery(name="Articole.findById", query = "SELECT a FROM Articole a WHERE a.id=:id")
})
public class Articole implements Serializable {
	private static final long serialVersionUID = 1L;

	private String categorie;

	@Lob
	private String descriere;
	
	@Id
	private int id;

	private String imagineURL;

	private String nume;

	private int pret;

	public Articole() {
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

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