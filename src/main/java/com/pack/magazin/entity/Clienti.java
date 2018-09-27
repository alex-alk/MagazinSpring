package com.pack.magazin.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clienti database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Clienti.findAll", query="SELECT c FROM Clienti c"),
	@NamedQuery(name="Clienti.findByEmail", query = "SELECT c FROM Clienti c WHERE c.email=:email"),
	@NamedQuery(name="Clienti.findById", query = "SELECT c FROM Clienti c WHERE c.id=:id")
})

public class Clienti implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;
	
	@Id
	private int id;

	private String nume;

	private String parola;

	private String prenume;

	private String telefon;

	public Clienti() {
		id = 0;
		email = "";
		nume = "";
		parola = "";
		prenume = "";
		telefon = "";
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getParola() {
		return this.parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String getPrenume() {
		return this.prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public boolean isNotValid() {
		if(email.isEmpty()||nume.isEmpty()||parola.isEmpty()||prenume.isEmpty()||parola.isEmpty())
			return true;return false;
	}
}