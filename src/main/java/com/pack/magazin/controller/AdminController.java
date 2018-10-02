package com.pack.magazin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.pack.magazin.dao.AdminDAO;
import com.pack.magazin.dao.ArticlesDAO;
import com.pack.magazin.dao.ClientsDAO;
import com.pack.magazin.dao.OffersDAO;
import com.pack.magazin.dao.OrdersDAO;
import com.pack.magazin.entity.Articles;
import com.pack.magazin.entity.Offers;
import com.pack.magazin.entity.Orders;
import com.pack.magazin.model.ArticlesUpload;
import com.pack.magazin.model.MainQuery;
import com.pack.magazin.model.OffersUpload;
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
	@Autowired 
	OffersDAO offersDAO;
	
	@RequestMapping(value="admin/optiuni", method=RequestMethod.POST)
	public String getAdmins(Model model) {
		return "admin/optiuni/index";
	}
	@RequestMapping(value="admin/optiuni", method=RequestMethod.GET)
	public String getAdminsGET(Model model) {
		return "admin/optiuni/index";
	}
	@RequestMapping(value="admin", method=RequestMethod.GET)
	public String adminPage() {
		return "admin/index";
	}
	//edit article
	@RequestMapping(value="/admin/optiuni/editeaza",method = RequestMethod.GET)
    public String editArticlePage(Model model, ArticlesUpload articlesUpload, @RequestParam("id") String idstr) {
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
	                     						             new File(sc.getRealPath("/resources/offers/"), fileName)));
	        outputStream.write(file.getBytes());
	        outputStream.flush();
	        outputStream.close();
	        model.addAttribute("msg", "Articol editat");
      } else {
          model.addAttribute("msg", "Selectează un fișier");
     }
     return "/admin/optiuni/editeaza";
    }
	//end edit article
	
	//add article
	@RequestMapping(value="/admin/optiuni/adauga",method = RequestMethod.GET)
    public String articolUploadSet(Model model, ArticlesUpload articlesUpload) {
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
		 	final File folder = new File(sc.getRealPath("/resources/offers"));
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
	                     						             new File(sc.getRealPath("/resources/offers/"), fileName)));
	        outputStream.write(file.getBytes());
	        outputStream.flush();
	        outputStream.close();
	        model.addAttribute("msg", "articol adăugat");
      } else {
          model.addAttribute("msg", "Selectează un fișier");
     }
     return "/admin/optiuni/adauga";
    }
    //end add article
    
    //delete article
    @RequestMapping(value="/admin/optiuni/stergere",method = RequestMethod.GET)
    public String deleteArticlePage(Model model) {
    	model.addAttribute("articole",articlesDAO.getArticles());
		model.addAttribute("mainQuery", mainQuery);	
		return "/admin/optiuni/stergere";
	}
    @RequestMapping(value="/admin/optiuni/stergere/cauta",method = RequestMethod.GET)
    public String deleteArticlePageSearch(Model model, @ModelAttribute("mainQuery")MainQuery mainQuery){
    	model.addAttribute("articole", articlesDAO.getArticlesByMainQuery(mainQuery));
		model.addAttribute("mainQuery", mainQuery);	
		return "/admin/optiuni/stergere";
	}
    //adaugare cauta si la edit
    
	@RequestMapping(value="/admin/optiuni/sterge",method = RequestMethod.POST)
    public String deleteArticle(Model model, @RequestParam("id")String idStr, HttpServletRequest request) throws IOException {
		model.addAttribute("mainQuery", mainQuery);
		ServletContext sc = request.getServletContext();
		Articles articol = articlesDAO.getArticolById(idStr);
	 	String fileURL = sc.getRealPath("/") + articol.getImageURL();
	 	File file = new File(fileURL);
	   	file.delete();
	   	int id = Integer.parseInt(idStr);
        articlesDAO.deleteArticol(id);
        model.addAttribute("articole",articlesDAO.getArticles());
     return "redirect:/admin/optiuni/stergere";
    }
	//display articles to be edited
	@RequestMapping(value="/admin/optiuni/editare", method = RequestMethod.GET)
	public String editare(Model model) {
		model.addAttribute("mainQuery", mainQuery);
		model.addAttribute("articole", articlesDAO.getArticles());
		return "/admin/optiuni/editare";
	}
	
	@RequestMapping(value="/admin/optiuni/editare/cauta", method = RequestMethod.GET)
	public String editareCauta(Model model, @ModelAttribute("mainQuery")MainQuery mainQuery) {
		model.addAttribute("articole", articlesDAO.getArticlesByMainQuery(mainQuery));
		return "/admin/optiuni/editare";
	}
	//end display articles to be edited
	
	@RequestMapping(value="/admin/optiuni/comenzi", method = RequestMethod.GET)
	public String displayComenzi(Model model) {
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
	public String deleteComenzi(Model model, @RequestParam("id")String idStr) {
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
