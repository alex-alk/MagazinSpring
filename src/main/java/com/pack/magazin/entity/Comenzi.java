package com.pack.magazin.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comenzi database table.
 * 
 */
@Entity
@NamedQuery(name="Comenzi.findAll", query="SELECT c FROM Comenzi c")
public class Comenzi implements Serializable {
	private static final long serialVersionUID = 1L;
	private int articolId;
	private int cantitate;
	private int clientiId;
	private int id;

	public Comenzi() {
	}


	@Column(name="articol_id")
	public int getArticolId() {
		return this.articolId;
	}

	public void setArticolId(int articolId) {
		this.articolId = articolId;
	}


	public int getCantitate() {
		return this.cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}


	@Column(name="clienti_id")
	public int getClientiId() {
		return this.clientiId;
	}

	public void setClientiId(int clientiId) {
		this.clientiId = clientiId;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}