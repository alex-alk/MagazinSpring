package com.pack.magazin.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pack.magazin.dao.ArticlesDAO;
import com.pack.magazin.model.MainQuery;

@Controller
public class ArticlesController {
	@Autowired
	ArticlesDAO articlesDAO;
	@Autowired
	MainQuery mainQuery;
	
	//home page
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("articles",articlesDAO.getArticles());
		model.addAttribute("mainQuery", mainQuery);
		return "/index";
	}
	
	@RequestMapping(value="/cauta", method = RequestMethod.GET)
	public String cauta(Model model, @ModelAttribute("mainQuery")MainQuery mainQuery) {
		model.addAttribute("articles", articlesDAO.getArticlesByMainQuery(mainQuery));
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
