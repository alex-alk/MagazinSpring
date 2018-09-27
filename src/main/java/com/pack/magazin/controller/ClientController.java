package com.pack.magazin.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pack.magazin.dao.ClientDAO;
import com.pack.magazin.entity.Clienti;

@Controller
public class ClientController {
	@Autowired
	ClientDAO clientDAO;
	
	@RequestMapping(value="/inregistrare", method = RequestMethod.GET)
	public String inregPage(Clienti client, Model model) {
		model.addAttribute("client", client);
		return "/inregistrare";
	}
	
	@RequestMapping(value="/inregistrare",method = RequestMethod.POST)
    public String inreg(Model model, @ModelAttribute("client")Clienti client) {
    	if (client.isNotValid()) {
			     model.addAttribute("msg", "Toate câmpurile sunt obligatorii");
		         return "/inregistrare";
		}
		clientDAO.addClient(client);
	    return "redirect:/";
    }
	
	@RequestMapping(value="/intra", method = RequestMethod.GET)
	public String intraPage(Clienti client, Model model) {
		model.addAttribute("client", client);
		return "/intra";
	}
	@RequestMapping(value="/intra",method = RequestMethod.POST)
    public String intra(Model model, @ModelAttribute("client")Clienti client, HttpServletResponse response) {
		Clienti clientBaza = clientDAO.getClientByEmail(client.getEmail());
    	if (clientBaza.getParola().equals(client.getParola())) {
    		Cookie cookie = new Cookie("nume", clientBaza.getNume());
    		cookie.setMaxAge(600);
    		response.addCookie(cookie);
		    return "redirect:/";
		}
	    model.addAttribute("msg", "Adresa de email nu corespunde cu parola");
	    return "/intra";
    }
	
	@RequestMapping(value="/cos", method = RequestMethod.GET)
	public String cosPageLink(Clienti client, Model model, HttpServletRequest request) {
		model.addAttribute("client", client);
		return "/cos";
	} 
	@RequestMapping(value="/cos", method = RequestMethod.POST)
	public String cosPageFromDescription(Model model, @RequestParam("id")String id, HttpServletResponse response) {
		Cookie cookie = new Cookie(id, "id");
		cookie.setMaxAge(120);
		response.addCookie(cookie);
		return "redirect:/cos";
	}
	@RequestMapping(value="/stergeDinCos", method = RequestMethod.POST)
	public String stergeDinCos(Model model, @RequestParam("id")String id, HttpServletResponse response) {
		Cookie cookie = new Cookie(id, "id");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "redirect:/cos";
	}
	
	/*
	@RequestMapping(value="/cos",method = RequestMethod.POST)
    public String toConform(Model model) {
		Clienti clientBaza = clientDAO.getClientByEmail(client.getEmail());
    	if (clientBaza.getParola().equals(client.getParola())) {
    		Cookie cookie = new Cookie("nume", clientBaza.getNume());
    		cookie.setMaxAge(60);
    		response.addCookie(cookie);
		    return "/confirm";
		}
	    model.addAttribute("msg", "Adresa de email nu corespunde cu parola");
	    return "/intra";
    }
	
	/*
	@RequestMapping(value="descriere", method = RequestMethod.GET)
	public String descriere(Model model, @RequestParam("id") String idstr) {
		int id = Integer.parseInt(idstr);
		model.addAttribute("articol",articolDAO.getArticolById(id));
		return "descriere";
	}
	
	@RequestMapping(value="admin/optiuni/adauga",method = RequestMethod.GET)
    public String articolUploadSet(Model model, ArticolUpload articolUpload) {//@Autowired
		model.addAttribute("articolUpload", articolUpload); 	
		return "admin/optiuni/adauga";
	}
	*/
    
}
