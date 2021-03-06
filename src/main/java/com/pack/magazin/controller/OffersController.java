package com.pack.magazin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import com.pack.magazin.dao.OffersDAO;
import com.pack.magazin.dao.OrdersDAO;
import com.pack.magazin.entity.Admin;
import com.pack.magazin.entity.Offers;
import com.pack.magazin.model.ArticlesUpload;
import com.pack.magazin.model.MainQuery;
import com.pack.magazin.model.OffersUpload;

@Controller
public class OffersController {
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
	
	@RequestMapping(value="/admin/optiuni/oferte", method = RequestMethod.GET)
	public String viewOffers(Model model, ArticlesUpload file, Admin admin, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute(admin);
		if(session.getAttribute("admin")==null) {
			model.addAttribute("msg","Trebuie să vă logați.");
			return "/admin/index";
		}
		model.addAttribute("file", file);
		List<Offers> offers = offersDAO.getAllOffers();
		model.addAttribute("offers", offers);
		return "/admin/optiuni/oferte";
	}
	
	@RequestMapping(value="/admin/optiuni/oferte", method = RequestMethod.POST)
	public String addOffers(Model model, @ModelAttribute(name="file")OffersUpload articlesUpload, ArticlesUpload fileA,
			Offers offer, HttpServletRequest request)throws IOException {
		ServletContext sc = request.getServletContext();
		MultipartFile file = articlesUpload.getFile();
    	if (!file.getOriginalFilename().isEmpty()) {
			String fullFileName = file.getOriginalFilename();
		 	String fileName = fullFileName.substring(fullFileName.lastIndexOf("\\")+1, fullFileName.length());   	  
		 	final File folder = new File(sc.getRealPath("/resources/offers/"));
		 	for (final File fileEntry : folder.listFiles()) {
			  if(fileEntry.getName().equals(fileName)) {
				 List<Offers> offers = offersDAO.getAllOffers();
				 model.addAttribute("offers", offers);
				 model.addAttribute("file", fileA);
			     model.addAttribute("msg", "Fișierul există deja");
		         return "/admin/optiuni/oferte";
			  }
		 	}
		   	offer.setUrl("/resources/offers/"+fileName);
		   	offersDAO.addOffer(offer);
		   	
		   	System.out.println(sc.getRealPath("/"));
	        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(
	                     						             new File(sc.getRealPath("/resources/offers/"), fileName)));
	        outputStream.write(file.getBytes());
	        outputStream.flush();
	        outputStream.close();
	        model.addAttribute("file", fileA);
	        model.addAttribute("msg", "Ofertă adăugată");
    	}else {
    		model.addAttribute("file", fileA);
    		model.addAttribute("msg", "Selectează un fișier");
    	}
	    List<Offers> offers = offersDAO.getAllOffers();
		model.addAttribute("offers", offers);
		model.addAttribute("file", fileA);
	    return "/admin/optiuni/oferte";
	}
	@RequestMapping(value="/admin/optiuni/oferte/sterge",method = RequestMethod.GET)
    public String deleteOffer(Model model, @RequestParam("id")String idStr, HttpServletRequest request, Offers offer, 
    		ArticlesUpload fileA, Admin admin) throws IOException {
		HttpSession session = request.getSession();
		ServletContext sc = request.getServletContext();
		model.addAttribute(admin);
		if(session.getAttribute("admin")==null) {
			model.addAttribute("msg","Trebuie să vă logați.");
			return "/admin/index";
		}
		model.addAttribute("mainQuery", mainQuery);
		Offers articol = offersDAO.getOfferById(Integer.parseInt(idStr));
	 	File file = new File(sc.getRealPath("/") + articol.getUrl());
	   	file.delete();
	   	int id = Integer.parseInt(idStr);
	   	offer = offersDAO.getOfferById(id);
        offersDAO.deleteOffer(offer);
        model.addAttribute("offers", offersDAO.getAllOffers());
        model.addAttribute("msg","Oferta a fost ștearsă.");
        model.addAttribute("file", fileA);
     return "/admin/optiuni/oferte";
    }
		
}
