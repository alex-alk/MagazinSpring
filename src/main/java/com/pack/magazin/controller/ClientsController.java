package com.pack.magazin.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pack.magazin.dao.ClientsDAO;
import com.pack.magazin.entity.Clients;

@Controller
public class ClientsController {
	@Autowired
	ClientsDAO clientsDAO;
	
	@RequestMapping(value="/inregistrare", method = RequestMethod.GET)
	public String inregPage(Clients client, Model model) {
		model.addAttribute("client", client);
		return "/inregistrare";
	}
	
	@RequestMapping(value="/inregistrare",method = RequestMethod.POST)
    public String inreg(Model model, @ModelAttribute("client")Clients client) {
    	if (client.isNotValid()) {
			     model.addAttribute("msg", "Toate câmpurile sunt obligatorii");
		         return "/inregistrare";
		}
		clientsDAO.addClient(client);
	    return "redirect:/";
    }
	
	@RequestMapping(value="/intra", method = RequestMethod.GET)
	public String intraPage(Clients client, Model model) {
		model.addAttribute("client", client);
		return "/intra";
	}
	@RequestMapping(value="/intra",method = RequestMethod.POST)
    public String intra(Model model, @ModelAttribute("client")Clients client, HttpServletResponse response) {
		Clients clientBaza = clientsDAO.getClientByEmail(client.getEmail());
    	if (clientBaza.getPassword().equals(client.getPassword())) {
    		Cookie cookie = new Cookie("name", clientBaza.getFamilyName());
    		Cookie cookieId = new Cookie("clientId", clientBaza.getId()+"");
    		cookie.setMaxAge(600);
    		response.addCookie(cookie);
    		response.addCookie(cookieId);
		    return "redirect:/";
		}
	    model.addAttribute("msg", "Adresa de email nu corespunde cu parola");
	    return "/intra";
    }
}
