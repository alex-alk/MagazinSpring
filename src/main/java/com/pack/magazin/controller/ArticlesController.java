package com.pack.magazin.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pack.magazin.dao.ArticlesDAO;
import com.pack.magazin.dao.ClientsDAO;
import com.pack.magazin.dao.OffersDAO;
import com.pack.magazin.entity.Articles;
import com.pack.magazin.entity.Offers;
import com.pack.magazin.model.MainQuery;
import com.pack.magazin.util.CookieUtil;

@Controller
public class ArticlesController {
	@Autowired
	ArticlesDAO articlesDAO;
	@Autowired
	OffersDAO offersDAO;
	@Autowired
	ClientsDAO clientsDAO;
	
	//home page
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Model model, MainQuery mainQuery, @CookieValue(name="clientId", defaultValue="")String clientId,
			HttpServletRequest request) {
		List<Articles> articles = articlesDAO.getArticles(mainQuery.getLimit());
		List<Articles> allArticles = articlesDAO.getAllArticles();
		int pages = (int) Math.ceil((double)allArticles.size()/(double)mainQuery.getLimit());
		List<Offers> offers = offersDAO.getAllOffers();
		if(!clientId.equals("")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", clientsDAO.getClientById(Integer.parseInt(clientId)));
		}
		model.addAttribute("offers", offers);
		model.addAttribute("page", mainQuery.getPage());
		model.addAttribute("pages", pages);
		model.addAttribute("articles", articles);
		model.addAttribute("mainQuery", mainQuery);
		return "/index";
	}
	
	@RequestMapping(value="/cauta", method = RequestMethod.GET)
	public String cauta(Model model, @ModelAttribute("mainQuery")MainQuery mainQuery) {
		List<Articles> articles = articlesDAO.getArticlesByMainQuery(mainQuery);
		List<Articles> allArticles = articlesDAO.getAllArticlesByMainQuery(mainQuery);
		int pages = (int) Math.ceil((double)allArticles.size()/(double)mainQuery.getLimit());
		List<Offers> offers = offersDAO.getAllOffers();
		model.addAttribute("offers", offers);
		model.addAttribute("page", mainQuery.getPage());
		model.addAttribute("pages", pages);
		model.addAttribute("articles", articles);
		return "/index";
	}
	//end home page
	
	@RequestMapping(value="/descriere", method = RequestMethod.GET)
	public String descriere(Model model, @RequestParam("id") String idstr) {
		model.addAttribute("article",articlesDAO.getArticolById(idstr));
		model.addAttribute("description", articlesDAO.getArticolById(idstr).getDescription());
		return "/descriere";
	}	
	
}
