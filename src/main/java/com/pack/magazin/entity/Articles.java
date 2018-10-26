package com.pack.magazin.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="articles")
@NamedQueries({
	@NamedQuery(name="Articles.findAll", query="SELECT a FROM Articles a"),
	@NamedQuery(name="Article.findById", query = "SELECT a FROM Articles a WHERE a.id=:id")
})
public class Articles implements Serializable {
	private static final long serialVersionUID = 1L;

	private String category;

	@Lob
	private String description;
	
	@Id
	private int id;

	private String imageURL;

	private String name;

	private int price;

	public Articles() {
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageURL() {
		return this.imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getname() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}