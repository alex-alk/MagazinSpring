package com.pack.magazin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pack.magazin.dao.ArticlesDAO;
import com.pack.magazin.dao.OrdersDAO;
import com.pack.magazin.entity.Articles;
import com.pack.magazin.entity.Clients;
import com.pack.magazin.entity.Orders;
import com.pack.magazin.model.OrdersForm;

@Controller
public class OrdersController {
	@Autowired
	OrdersDAO ordersDAO;
	@Autowired
	ArticlesDAO articlesDAO;
	
	@RequestMapping(value="/cos", method = RequestMethod.GET)
	public String cosPageLink(Clients client, Model model, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		List<Articles> articles = new ArrayList<>();
		for(Cookie cookie:cookies) {
			if(cookie.getValue().equals("id")) {
				articles.add(articlesDAO.getArticolById(cookie.getName()));
			}
		}
		model.addAttribute("client", client);
		model.addAttribute("articles", articles);
		return "/cos";
	} 
	@RequestMapping(value="/cos", method = RequestMethod.POST)
	public String cosPageFromDescription(Model model, @RequestParam("id")String id, HttpServletResponse response) {
		Cookie cookie = new Cookie(id, "id");
		cookie.setMaxAge(320);
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
	public String validarePage(Model model, HttpServletRequest request, Clients client, OrdersForm ordersForm) {
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
						int artId = Integer.parseInt(cookieId.getName());
						String quantityStr = request.getParameter(cookieId.getName());
						if(quantityStr.equals("")||quantityStr.equals("0")) {
							//Cookie[] cookies = request.getCookies();
							List<Articles> articles = new ArrayList<>();
							//for(Cookie cookie:cookies) {
								//if(cookie.getValue().equals("id")) {
									articles.add(articlesDAO.getArticolById(cookieId.getName()));
								//}
							//}
							model.addAttribute("articles", articles);
							model.addAttribute("msg","Cantitatea unui produs nu poate fi zero");
							return "/cos";
						}
						int quantity = Integer.parseInt(quantityStr);
						idQ.put(artId, quantity);
					}
				}
				model.addAttribute("idQ", idQ);
				model.addAttribute(ordersForm);
				return "/validare";
			}
		}
		model.addAttribute("client", client);
		model.addAttribute("msg","Pentru a valida comanda trebuie sa vă logați.");
		return "/intra";
	}
	@RequestMapping(value = "/trimite", method = RequestMethod.POST)
	public String trimite(Model model, @ModelAttribute("ordersForm")OrdersForm ordersForm, Orders order) {
		String quantity = ordersForm.getQuantity();				//Example: quantity = "1 2"
		String idArticle = ordersForm.getArticleId();
		String[] quantityArray = quantity.split(" ");			//quantity array = [1, 2]
		String[] idArticlesArray = idArticle.split(" ");
		int idClientToEntity = Integer.parseInt(ordersForm.getClientId());
		for(String q: quantityArray) {
			for(String id:idArticlesArray) {
				int quantityToEntity = Integer.parseInt(q);
				int idArticlesToEntity = Integer.parseInt(id);
				System.out.println(idClientToEntity+"--"+idArticlesToEntity +" "+quantityToEntity);

				order.setClientId(idClientToEntity);
				order.setArticlesId(idArticlesToEntity);
				order.setQuantity(quantityToEntity);
				ordersDAO.addOrder(order);
			}	
		}
		model.addAttribute("msg", "Comanda a fost trimisă");
		return "/succes";
	} 
}
