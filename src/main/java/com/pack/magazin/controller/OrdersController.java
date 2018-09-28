package com.pack.magazin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pack.magazin.dao.ClientsDAO;
import com.pack.magazin.dao.OrdersDAO;
import com.pack.magazin.entity.Clients;
import com.pack.magazin.entity.Orders;
import com.pack.magazin.model.OrdersForm;

@Controller
public class OrdersController {
	@Autowired
	OrdersDAO ordersDAO;
	
	@RequestMapping(value="/cos", method = RequestMethod.GET)
	public String cosPageLink(Clients client, Model model, HttpServletRequest request) {
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
	@RequestMapping(value="/stergeDinCos", method = RequestMethod.GET)
	public String stergeDinCos(Model model, @RequestParam("id")String id, HttpServletResponse response) {
		Cookie cookie = new Cookie(id, "id");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "redirect:/cos";
	}
	
	@RequestMapping(value="/validareComanda", method = RequestMethod.POST)
	public String validarePage(Model model, HttpServletRequest request, Clients client) {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("name")) {
				String clientId = "";
				for(Cookie id:cookies) {
					if(id.getName().equals("clientId")) {
						clientId = id.getValue();
					}
				}
				model.addAttribute("clientId", clientId);
				Map<Integer, Integer> idQ = new HashMap<>();
				for(Cookie cookieId:cookies) {
					if(cookieId.getValue().equals("id")) {
						System.out.println(cookieId.getValue()+"---"+cookieId.getName());
						int artId = Integer.parseInt(cookieId.getName());
						int quantity = Integer.parseInt(request.getParameter(cookieId.getName()));
						idQ.put(artId, quantity);
					}
				}
				OrdersForm ordersForm = new OrdersForm();// incearca si fara new si cu argument
				model.addAttribute("idQ", idQ);
				model.addAttribute(ordersForm);
				return "/validare";
			}
		}
		model.addAttribute("client", client);
		model.addAttribute("msg","trebuie sa bla bla bla");
		return "/intra";
	}
	@RequestMapping(value = "/trimite", method = RequestMethod.POST)
	public String trimite(Model model, @ModelAttribute("ordersForm")OrdersForm ordersForm, Orders order) {
		int idClient = Integer.parseInt(ordersForm.getClientId());
		int idArticle = Integer.parseInt(ordersForm.getArticleId());
		int quantity = Integer.parseInt(ordersForm.getQuantity());
		order.setClientId(idClient);
		order.setArticlesId(idArticle);
		order.setQuantity(quantity);
		ordersDAO.addOrder(order);
		model.addAttribute("msg",ordersForm.getArticleId());
		return "/succes";
	} 
}
