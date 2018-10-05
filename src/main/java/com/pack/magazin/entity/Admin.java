package com.pack.magazin.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;


/**
 * The persistent class for the admin database table.
 * 
 */
@Entity
@Component
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;

	private String password;

	private String username;

	public Admin() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}