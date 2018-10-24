package com.pack.magazin.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clienti database table.
 * 
 */
@Entity
@Table(name="clients")
@NamedQueries({
	@NamedQuery(name="Clients.findAll", query="SELECT c FROM Clients c"),
	@NamedQuery(name="Clients.findByEmail", query = "SELECT c FROM Clients c WHERE c.email=:email"),
	@NamedQuery(name="Clients.findById", query = "SELECT c FROM Clients c WHERE c.id=:id")
})

public class Clients implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;
	
	@Id
	private int id;
	
	@Column(name="family_name")
	private String familyName;

	private String password;
	
	@Column(name="first_name")
	private String firstName;

	private String tel;

	public Clients() {
		id = 0;
		email = "";
		familyName = "";
		password = "";
		firstName = "";
		tel = "";
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

	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	public boolean isNotValid() {
		if(email.isEmpty()||familyName.isEmpty()||password.isEmpty()||firstName.isEmpty()||password.isEmpty())
			return true;return false;
	}
}