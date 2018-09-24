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
	@RequestMapping(value="inregistrare", method = RequestMethod.GET)
	public String getPage(Clienti client, Model model) {
		model.addAttribute(client);
		return "inregistrare";
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
    @RequestMapping(value="inregistrare",method = RequestMethod.POST)
    public String articolUpload(Model model, @ModelAttribute("client")Clienti client) {
    	if (client.isNotValid()) {
			     model.addAttribute("msg", "Toate câmpurile sunt obligatorii");
		         return "inregistrare";
		}
		clientDAO.addClient(client);
	    model.addAttribute("msg", "Înregistrat cu succes");
	    return "succes";
    }
}
