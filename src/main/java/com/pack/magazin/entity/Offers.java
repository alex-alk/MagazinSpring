package com.pack.magazin.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oferte database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Offers.findAll", query="SELECT o FROM Offers o"),
	@NamedQuery(name="Offers.findById", query = "SELECT o FROM Offers o WHERE o.id=:id")
})
public class Offers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String url;
	
	public Offers() {
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