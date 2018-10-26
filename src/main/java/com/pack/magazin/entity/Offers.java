package com.pack.magazin.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="offers")
@NamedQueries({
	@NamedQuery(name="Offers.findAll", query="SELECT o FROM Offers o"),
	@NamedQuery(name="Offers.findById", query = "SELECT o FROM Offers o WHERE o.id=:id")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Offers implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlAttribute
	@Id
	private int id;
	
	@XmlElement
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