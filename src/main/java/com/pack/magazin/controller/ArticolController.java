package com.pack.magazin.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pack.magazin.dao.ArticolDAO;

@Controller
public class ArticolController {
	@Autowired
	ArticolDAO articolDAO;
	
	@RequestMapping("/articole")
	public String getArticole(Model model) {
		model.addAttribute("articole",articolDAO.getArticole());
		return "articole";
	}
}
