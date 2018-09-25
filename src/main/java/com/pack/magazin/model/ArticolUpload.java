package com.pack.magazin.model;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ArticolUpload {
	private MultipartFile file;
	private String nume;
	private String pretStr;
	private String categorie;
	private String descriere;
	private int pret;
	private String id;

	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public boolean isNotValid() {
		if(nume.isEmpty()||pretStr.isEmpty()||categorie.isEmpty()||descriere.isEmpty()||isNotNumber())return true;return false;
	}
	public String getPretStr() {
		return pretStr;
	}
	public void setPretStr(String pretStr) {
		this.pretStr = pretStr;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public int getPret() {
		setPret(pretStr);
		return pret;
	}
	public void setPret(String pretStr) {
		if(!isNotNumber()) {
			pret = Integer.parseInt(pretStr);
		}
	}
	public boolean isNotNumber() {
		try {
			Integer.parseInt(pretStr);
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
