package com.pack.magazin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pack.magazin.dao.OffersDAO;
import com.pack.magazin.entity.Offers;

@RestController
public class OffersService {
	@Autowired
	OffersDAO offersDAO;
	
	@RequestMapping(value="/offers", method= RequestMethod.GET, produces="application/json")
	public List<Offers> getOffers() {
		System.out.println("aaaaaaaaaaa");
		return offersDAO.getAllOffers();
	}
	
}
