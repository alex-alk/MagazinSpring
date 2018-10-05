package com.pack.magazin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.pack.magazin.dao.AdminDAO;
import com.pack.magazin.dao.ArticlesDAO;
import com.pack.magazin.dao.ClientsDAO;
import com.pack.magazin.dao.OrdersDAO;
import com.pack.magazin.entity.Admin;
import com.pack.magazin.entity.Articles;
import com.pack.magazin.entity.Orders;
import com.pack.magazin.model.ArticlesUpload;
import com.pack.magazin.model.MainQuery;
import com.pack.magazin.model.OrdersTable;

@Controller
public class AdminController {
	@Autowired
	AdminDAO adminDAO;
	@Autowired
	ArticlesDAO articlesDAO;
	@Autowired
	MainQuery mainQuery;
	@Autowired
	OrdersDAO ordersDAO;
	@Autowired
	ClientsDAO clientsDAO;
	
	@RequestMapping(value="admin/optiuni", method=RequestMethod.POST)
	public String getAdmins(Model model, @ModelAttribute("admin")Admin admin, HttpServletRequest request) {
		Admin adminBaza = adminDAO.getAdmin();
		if(adminBaza.getUsername().equals(admin.getUsername())) {
			if(adminBaza.getPassword().equals(admin.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin.getUsername());
				return "admin/optiuni/index";
			}
		}
		model.addAttribute("msg","Numele nu corespunde cu parola.");
		return "admin/index";
	}
	@RequestMapping(value="admin/optiuni", method=RequestMethod.GET)
	public String getAdminsGET(Model model, HttpServletRequest request, Admin admin) {
		HttpSession session = request.getSession();
		model.addAttribute(admin);
		if(session.getAttribute("admin")==null) {
			model.addAttribute("msg","Trebuie să vă logați.");
			return "/admin/index";
		}
		return "/admin/optiuni/index";
	}
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String adminPage(Model model, Admin admin, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute(admin);
		if(session.getAttribute("admin")!=null) {
			return "/admin/optiuni/index";
		}
		return "/admin/index";
	}
	
	@RequestMapping(value="/admin/optiuni/editeaza",method = RequestMethod.GET)
    public String editArticlePage(Model model, ArticlesUpload articlesUpload, @RequestParam("id") String idstr,
    		HttpServletRequest request, Admin admin) {
		HttpSession session = request.getSession();
		model.addAttribute(admin);
		if(session.getAttribute("admin")==null) {
			model.addAttribute("msg","Trebuie să vă logați.");
			return "/admin/index";
		}
		Articles articol = articlesDAO.getArticolById(idstr);
		model.addAttribute("articol", articol);
		model.addAttribute("articolUpload", articlesUpload); 	
		return "/admin/optiuni/editeaza";
	}
	@RequestMapping(value="/admin/optiuni/editeaza",method = RequestMethod.POST)
    public String editArticle(Model model, @ModelAttribute("articolUpload")ArticlesUpload articlesUpload, HttpServletRequest request) throws IOException {
    	MultipartFile file = articlesUpload.getFile();
    	if(articlesUpload.isNotValid()) {
    		model.addAttribute("msg","Toate câmpurile sunt obligatorii");
    		return "/admin/optiuni/editeaza";
    	}
    	if (!file.getOriginalFilename().isEmpty()) {
			String fullFileName = file.getOriginalFilename();
			Articles articol = articlesDAO.getArticolById(articlesUpload.getId());
		 	String fileName = fullFileName.substring(fullFileName.lastIndexOf("\\")+1, fullFileName.length());
		   	articol.setCategory(articlesUpload.getCategory());
		   	articol.setDescription(articlesUpload.getDescription());
		   	articol.setImageURL("/resources/uploads/" + fileName);
		   	articol.setName(articlesUpload.getName());
		   	articol.setPrice(articlesUpload.getPrice());
		   	articlesDAO.updateArticol(articol);
		   	ServletContext sc = request.getServletContext();
	        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(
	                     						             new File(sc.getRealPath("/resources/uploads/"), fileName)));
	        outputStream.write(file.getBytes());
	        outputStream.flush();
	        outputStream.close();
	        model.addAttribute("msg", "Articol editat.");
      } else {
          model.addAttribute("msg", "Selectează un fișier");
     }
     return "/admin/optiuni/editeaza";
    }
	
	@RequestMapping(value="/admin/optiuni/adauga",method = RequestMethod.GET)
    public String articolUploadSet(Model model, ArticlesUpload articlesUpload, HttpServletRequest request, Admin admin) {
		HttpSession session = request.getSession();
		model.addAttribute(admin);
		if(session.getAttribute("admin")==null) {
			model.addAttribute("msg","Trebuie să vă logați.");
			return "/admin/index";
		}
		model.addAttribute("articolUpload", articlesUpload); 	
		return "/admin/optiuni/adauga";
	}
	
    @RequestMapping(value="/admin/optiuni/articolUpload",method = RequestMethod.POST)
    public String articlesUpload(Model model, @ModelAttribute("articolUpload")ArticlesUpload articlesUpload, 
    		HttpServletRequest request, Articles articol) throws IOException {
    	ServletContext sc = request.getServletContext();
    	MultipartFile file = articlesUpload.getFile();
    	if(articlesUpload.isNotValid()) {
    		model.addAttribute("msg","Toate câmpurile sunt obligatorii");
    		return "admin/optiuni/adauga";
    	}
    	if (!file.getOriginalFilename().isEmpty()) {
			String fullFileName = file.getOriginalFilename();
		 	String fileName = fullFileName.substring(fullFileName.lastIndexOf("\\")+1, fullFileName.length());   	  
		 	final File folder = new File("E:/Projects/Eclipse EE workspace/MagazinSpring/src/main/webapp/resources/uploads");
		 	System.out.println(sc.getRealPath("/"));
		 	for (final File fileEntry : folder.listFiles()) {
			  if(fileEntry.getName().equals(fileName)) {
			     model.addAttribute("msg", "Fișierul există deja");
		         return "/admin/optiuni/adauga";
			  }
		 	}
		   	articol.setCategory(articlesUpload.getCategory());
		   	articol.setDescription(articlesUpload.getDescription());
		   	articol.setImageURL("/resources/uploads/" + fileName);
		   	articol.setName(articlesUpload.getName());
		   	articol.setPrice(articlesUpload.getPrice());
		   	articlesDAO.addArticol(articol);
	        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(
	                     						             new File("E:/Projects/Eclipse EE workspace/MagazinSpring/src/main/webapp/resources/uploads", fileName)));
	        System.out.println(fileName);
	        System.out.println(sc.getRealPath("/resources/uploads/"));
	        outputStream.write(file.getBytes());
	        outputStream.flush();
	        outputStream.close();
	        model.addAttribute("msg", "Articol adăugat");
      } else {
          model.addAttribute("msg", "Selectează un fișier");
     }
     return "/admin/optiuni/adauga";
    }
    
    //delete article
    @RequestMapping(value="/admin/optiuni/stergere",method = RequestMethod.GET)
    public String deleteArticlePage(Model model, HttpServletRequest request, Admin admin) {
    	model.addAttribute(admin);
    	HttpSession session = request.getSession();
		if(session.getAttribute("admin")==null) {
			model.addAttribute("msg","Trebuie să vă logați.");
			return "/admin/index";
		}
    	model.addAttribute("articles",articlesDAO.getAllArticles());
		model.addAttribute("mainQuery", mainQuery);	
		return "/admin/optiuni/stergere";
	}
    @RequestMapping(value="/admin/optiuni/stergere/cauta",method = RequestMethod.GET)
    public String deleteArticlePageSearch(Model model, @ModelAttribute("mainQuery")MainQuery mainQuery,
    		HttpServletRequest request, Admin admin){
    	model.addAttribute(admin);
    	HttpSession session = request.getSession();
		if(session.getAttribute("admin")==null) {
			model.addAttribute("msg","Trebuie să vă logați.");
			return "/admin/index";
		}
    	model.addAttribute("articles", articlesDAO.getArticlesByMainQuery(mainQuery));
		model.addAttribute("mainQuery", mainQuery);	
		return "/admin/optiuni/stergere";
	}
    
	@RequestMapping(value="/admin/optiuni/sterge",method = RequestMethod.GET)
    public String deleteArticle(Model model, @RequestParam("id")String idStr, HttpServletRequest request, Admin admin) throws IOException {
		HttpSession session = request.getSession();
		model.addAttribute(admin);
		if(session.getAttribute("admin")==null) {
			model.addAttribute("msg","Trebuie să vă logați.");
			return "/admin/index";
		}
		model.addAttribute("mainQuery", mainQuery);
		Articles articol = articlesDAO.getArticolById(idStr);
	 	String fileURL = "E:/Projects/Eclipse EE workspace/MagazinSpring/src/main/webapp" + articol.getImageURL();
	 	File file = new File(fileURL);
	   	file.delete();
	   	int id = Integer.parseInt(idStr);
        articlesDAO.deleteArticol(id);
        model.addAttribute("articole",articlesDAO.getAllArticles());
     return "redirect:/admin/optiuni/stergere";
    }
	
	//display articles to be edited
	@RequestMapping(value="/admin/optiuni/editare", method = RequestMethod.GET)
	public String editare(Model model, HttpServletRequest request, Admin admin) {
		HttpSession session = request.getSession();
		model.addAttribute(admin);
		if(session.getAttribute("admin")==null) {
			model.addAttribute("msg","Trebuie să vă logați.");
			return "/admin/index";
		}
		model.addAttribute("mainQuery", mainQuery);
		model.addAttribute("articles", articlesDAO.getAllArticles());
		return "/admin/optiuni/editare";
	}
	
	@RequestMapping(value="/admin/optiuni/editare/cauta", method = RequestMethod.GET)
	public String editareCauta(Model model, @ModelAttribute("mainQuery")MainQuery mainQuery, HttpServletRequest request, Admin admin) {
		HttpSession session = request.getSession();
		model.addAttribute(admin);
		if(session.getAttribute("admin")==null) {
			model.addAttribute("msg","Trebuie să vă logați.");
			return "/admin/index";
		}
		model.addAttribute("articles", articlesDAO.getArticlesByMainQuery(mainQuery));
		return "/admin/optiuni/editare";
	}
	//end display articles to be edited
	
	@RequestMapping(value="/admin/optiuni/comenzi", method = RequestMethod.GET)
	public String displayComenzi(Model model, HttpServletRequest request, Admin admin) {
		HttpSession session = request.getSession();
		model.addAttribute(admin);
		if(session.getAttribute("admin")==null) {
			model.addAttribute("msg","Trebuie să vă logați.");
			return "/admin/index";
		}
		List<Orders> orders;
		orders = ordersDAO.getAllOrders();
		OrdersTable ordersTable;
		List<OrdersTable> ordersTableList = new ArrayList<>();
		for(Orders order:orders) {
			ordersTable= new OrdersTable();
			ordersTable.setEmail(clientsDAO.getClientById(order.getClientiId()).getEmail());
			ordersTable.setName(clientsDAO.getClientById(order.getClientiId()).getFamilyName());
			ordersTable.setTel(clientsDAO.getClientById(order.getClientiId()).getTel());
			ordersTable.setArtName(articlesDAO.getArticolById(""+order.getArticlesId()).getname());
			ordersTable.setQuantity(order.getQuantity()+"");
			ordersTable.setOrderId(order.getId()+"");
			ordersTableList.add(ordersTable);
		}
		model.addAttribute("ordersTableList", ordersTableList);
		return "/admin/optiuni/comenzi";
	}
	@RequestMapping(value="/admin/optiuni/comenzi/sterge", method = RequestMethod.GET)
	public String deleteComenzi(Model model, @RequestParam("id")String idStr, HttpServletRequest request, Admin admin) {
		HttpSession session = request.getSession();
		model.addAttribute(admin);
		if(session.getAttribute("admin")==null) {
			model.addAttribute("msg","Trebuie să vă logați.");
			return "/admin/index";
		}
		List<Orders> orders;
		ordersDAO.deleteOrder(ordersDAO.getOrderById(Integer.parseInt(idStr)));
		orders = ordersDAO.getAllOrders();
		OrdersTable ordersTable;
		List<OrdersTable> ordersTableList = new ArrayList<>();
		for(Orders order:orders) {
			ordersTable= new OrdersTable();
			ordersTable.setEmail(clientsDAO.getClientById(order.getClientiId()).getEmail());
			ordersTable.setName(clientsDAO.getClientById(order.getClientiId()).getFamilyName());
			ordersTable.setTel(clientsDAO.getClientById(order.getClientiId()).getTel());
			ordersTable.setArtName(articlesDAO.getArticolById(""+order.getArticlesId()).getname());
			ordersTable.setQuantity(order.getQuantity()+"");
			ordersTable.setOrderId(order.getId()+"");
			ordersTableList.add(ordersTable);
		}
		model.addAttribute("ordersTableList", ordersTableList);
		return "/admin/optiuni/comenzi";
	}	
}
