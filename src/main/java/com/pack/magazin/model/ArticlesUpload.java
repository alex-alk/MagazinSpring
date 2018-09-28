package com.pack.magazin.model;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ArticlesUpload {
	private MultipartFile file;
	private String name;
	private String priceStr;
	private String category;
	private String description;
	private int price;
	private String id;

	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isNotValid() {
		if(name.isEmpty()||priceStr.isEmpty()||category.isEmpty()||description.isEmpty()||isNotNumber())return true;return false;
	}
	public String getPriceStr() {
		return priceStr;
	}
	public void setPriceStr(String priceStr) {
		this.priceStr = priceStr;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		setPrice(priceStr);
		return price;
	}
	public void setPrice(String priceStr) {
		if(!isNotNumber()) {
			price = Integer.parseInt(priceStr);
		}
	}
	public boolean isNotNumber() {
		try {
			Integer.parseInt(priceStr);
			return false;
		}catch(Exception e) {
			return true;
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
