package com.pack.magazin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pack.magazin.dao.ArticlesDAO;
import com.pack.magazin.entity.Articles;
import com.pack.magazin.model.MainQuery;

@Controller
public class ArticlesController {
	@Autowired
	ArticlesDAO articlesDAO;
	
	//home page
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Model model, MainQuery mainQuery) {
		List<Articles> articles = articlesDAO.getArticles(mainQuery.getLimit());
		List<Articles> allArticles = articlesDAO.getAllArticles();
		int pages = (int) Math.ceil((double)allArticles.size()/(double)mainQuery.getLimit());
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
