package com.pack.magazin.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		model.addAttribute("msg", "Ați fost înregistrat cu succes.");
	    return "/intra";
    }
	
	@RequestMapping(value="/intra", method = RequestMethod.GET)
	public String intraPage(Clients client, Model model, HttpServletRequest request) {
		model.addAttribute("client", client);
		return "/intra";
	}
	
	@RequestMapping(value="/intra",method = RequestMethod.POST)
    public String intra(Model model, @ModelAttribute("client")Clients client, HttpServletResponse response,
    		HttpServletRequest request) {
		Clients clientBaza = clientsDAO.getClientByEmail(client.getEmail());
    	if (clientBaza.getEmail().equals(client.getEmail())&&!client.getEmail().isEmpty()) {
    		if(clientBaza.getPassword().equals(client.getPassword())){
	    		HttpSession session1 = request.getSession();
	    		session1.invalidate();
	    		HttpSession session = request.getSession();
	    		session.setAttribute("user", clientBaza);
	    		Cookie cookie = new Cookie("clientId", clientBaza.getId()+"");
	    		cookie.setMaxAge(300);
	    		response.addCookie(cookie);
			    return "redirect:/";
    		}
		}
	    model.addAttribute("msg", "Adresa de email nu corespunde cu parola");
	    return "/intra";
    }
}
