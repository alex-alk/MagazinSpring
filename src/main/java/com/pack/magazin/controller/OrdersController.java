package com.pack.magazin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import com.pack.magazin.util.CookieUtil;

@Controller
public class OrdersController {
	@Autowired
	OrdersDAO ordersDAO;
	@Autowired
	ArticlesDAO articlesDAO;
	
	@RequestMapping(value="/cos", method = RequestMethod.GET)
	public String cosPageLink(Clients client, Model model, HttpServletRequest request) {
		return "/cos";
	} 
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/cos", method = RequestMethod.POST)
	public String cosPageFromDescription(Model model, @RequestParam("idA")String id, 
			HttpServletRequest request, Clients client) {
		HttpSession session = request.getSession();
		Clients user = (Clients)session.getAttribute("user");
		if(user==null) {
			Cookie[] cookies = request.getCookies();
			String userId = CookieUtil.getCookieValue(cookies, "clientId");
			if(userId.equals("")) {
				model.addAttribute("client", client);
				model.addAttribute("msg","Pentru a adăuga produse trebuie sa vă logați.");
				return "/intra";
			}
		}
		List<Articles> articles;
		if(session.getAttribute("products")==null) {
			articles = new ArrayList<>();
		}else {
			articles = (List<Articles>)session.getAttribute("products");
		}
		for(Articles article:articles) {
			if(article.getId()==Integer.parseInt(id)) {
				model.addAttribute("msg", "Articolul se află deja în coș.");
				model.addAttribute("article",articlesDAO.getArticolById(id));
				model.addAttribute("description", articlesDAO.getArticolById(id).getDescription());
				return "/descriere";
			}
		}
		articles.add(articlesDAO.getArticolById(id));
		session.setAttribute("products", articles);
		session.setMaxInactiveInterval(300);
		return "redirect:/cos";
	}
	@RequestMapping(value="/stergeDinCos", method = RequestMethod.GET)
	public String stergeDinCos(Model model, @RequestParam("idA")String id,
			@SessionAttribute(name="products")List<Articles> articles) {
		for(Articles art:articles) {
			if(Integer.toString(art.getId()).equals(id)) {
				articles.remove(art);
				return "redirect:/cos";
			}
		}
		return "";
	}
	
	@RequestMapping(value="/validareComanda", method = RequestMethod.POST)
	public String validarePage(Model model, HttpServletRequest request, Clients client, OrdersForm ordersForm, 
			HttpServletResponse response, @SessionAttribute(name="products")List<Articles> products) {
		HttpSession session = request.getSession();
		Clients user = (Clients)session.getAttribute("user");
		if(user==null) {
			Cookie[] cookies = request.getCookies();
			String userId = CookieUtil.getCookieValue(cookies, "clientId");
			if(userId.equals("")) {
				model.addAttribute("client", client);
				model.addAttribute("msg","Pentru a valida comanda trebuie sa vă logați.");
				return "/intra";
			}
		}
		String id="";
		String quantity="";
		List<String> names = new ArrayList<>();
		List<String> prices = new ArrayList<>();
		List<String> quantities = new ArrayList<>();
		List<String> costs = new ArrayList<>();
		
		for(Articles product:products){
			id+= product.getId()+" ";
			quantity+=request.getParameter(product.getId()+"")+" ";
			names.add(product.getname());
			quantities.add(request.getParameter(product.getId()+""));
			prices.add(product.getPrice()+"");
			costs.add((Integer.parseInt(request.getParameter(product.getId()+""))
					
					*product.getPrice())+"");
		}
		ordersForm.setQuantity(quantity);
		ordersForm.setArticleId(id);
		ordersForm.setClientId(user.getId()+"");
		
		Map<String,List<String>> tableSend = new LinkedHashMap<String, List<String>>();
		tableSend.put("names", names);
		tableSend.put("prices", prices);
		tableSend.put("quantities", quantities);
		tableSend.put("costs", costs);
		
		session.setAttribute("tableSend", tableSend);
		session.setMaxInactiveInterval(300);
		return "validare";
	}
	@RequestMapping(value = "/trimite", method = RequestMethod.POST)
	public String trimite(Model model, Orders order, @SessionAttribute(name="ordersForm")OrdersForm ordersForm) {
		
		String quantity = ordersForm.getQuantity();				//Example: quantity = "1 2"
		String idArticle = ordersForm.getArticleId();
		String[] quantityArray = quantity.split(" ");			//quantity array = [1, 2]
		String[] idArticlesArray = idArticle.split(" ");
		int idClientToEntity = Integer.parseInt(ordersForm.getClientId());
		int i = 0;
		for(String q: quantityArray) {
				int quantityToEntity = Integer.parseInt(q);
				int idArticlesToEntity = Integer.parseInt(idArticlesArray[i]);
				System.out.println(idClientToEntity+"-"+idArticlesToEntity +"-"+quantityToEntity);
				order.setClientId(idClientToEntity);
				order.setArticlesId(idArticlesToEntity);
				order.setQuantity(quantityToEntity);
				ordersDAO.addOrder(order);
			i++;
		}
		model.addAttribute("msg", "Comanda a fost trimisă");
		return "/succes";
	} 
}
