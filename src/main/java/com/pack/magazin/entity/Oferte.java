package com.pack.magazin.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oferte database table.
 * 
 */
@Entity
@NamedQuery(name="Oferte.findAll", query="SELECT o FROM Oferte o")
public class Oferte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String url;

	public Oferte() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}