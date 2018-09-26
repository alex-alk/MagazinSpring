package com.pack.magazin.controller;

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
    public String intra(Model model, @ModelAttribute("client")Clienti client) {
		Clienti clientBaza = clientDAO.getClientByEmail(client.getEmail());
    	if (clientBaza.getParola().equals(client.getParola())) {
		         return "redirect:/index";
		}
	    model.addAttribute("msg", "Înregistrat cu succes");
	    return "/inregistrare";
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
