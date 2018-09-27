package com.pack.magazin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.pack.magazin.dao.ArticolDAO;
import com.pack.magazin.entity.Articole;
import com.pack.magazin.model.ArticolUpload;
import com.pack.magazin.model.MainQuery;

@Controller
public class ArticolController {
	@Autowired
	ArticolDAO articolDAO;
	@Autowired
	MainQuery mainQuery;
	
	//home page
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Model model, @CookieValue(value="nume", defaultValue="none")String cookieValue) {
		model.addAttribute("articole",articolDAO.getArticole());
		model.addAttribute("mainQuery", mainQuery);
		model.addAttribute("nume", cookieValue);
		return "/index";
	}
	
	@RequestMapping(value="/cauta", method = RequestMethod.GET)
	public String cauta(Model model, @ModelAttribute("mainQuery")MainQuery mainQuery) {
		model.addAttribute("articole", articolDAO.getArticoleByMainQuery(mainQuery));
		return "/index";
	}
	//end home page
	
	@RequestMapping(value="/descriere", method = RequestMethod.GET)
	public String descriere(Model model, @RequestParam("id") String idstr) {
		model.addAttribute("articol",articolDAO.getArticolById(idstr));
		return "/descriere";
	}
	//display articles to be edited
	@RequestMapping(value="/admin/optiuni/editare", method = RequestMethod.GET)
	public String editare(Model model) {
		model.addAttribute("mainQuery", mainQuery);
		model.addAttribute("articole", articolDAO.getArticole());
		return "/admin/optiuni/editare";
	}
	
	@RequestMapping(value="/admin/optiuni/editare/cauta", method = RequestMethod.GET)
	public String editareCauta(Model model, @ModelAttribute("mainQuery")MainQuery mainQuery) {
		model.addAttribute("articole", articolDAO.getArticoleByMainQuery(mainQuery));
		return "/admin/optiuni/editare";
	}
	//end display articles to be edited
	
	//edit article
	@RequestMapping(value="/admin/optiuni/editeaza",method = RequestMethod.GET)
    public String editArticlePage(Model model, ArticolUpload articolUpload, @RequestParam("id") String idstr) {
		Articole articol = articolDAO.getArticolById(idstr);
		model.addAttribute("articol", articol);
		model.addAttribute("articolUpload", articolUpload); 	
		return "/admin/optiuni/editeaza";
	}
	@RequestMapping(value="/admin/optiuni/editeaza",method = RequestMethod.POST)
    public String editArticle(Model model, @ModelAttribute("articolUpload")ArticolUpload articolUpload) throws IOException {
    	MultipartFile file = articolUpload.getFile();
    	if(articolUpload.isNotValid()) {
    		model.addAttribute("msg","Toate câmpurile sunt obligatorii");
    		return "/admin/optiuni/editeaza";
    	}
    	if (!file.getOriginalFilename().isEmpty()) {
			String fullFileName = file.getOriginalFilename();
			Articole articol = articolDAO.getArticolById(articolUpload.getId());
		 	String fileName = fullFileName.substring(fullFileName.lastIndexOf("\\")+1, fullFileName.length());
		   	articol.setCategorie(articolUpload.getCategorie());
		   	articol.setDescriere(articolUpload.getDescriere());
		   	articol.setImagineURL("/resources/uploads/" + fileName);
		   	articol.setNume(articolUpload.getNume());
		   	articol.setPret(articolUpload.getPret());
		   	articolDAO.updateArticol(articol);
	        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(
	                     						             new File("E:\\Projects\\Eclipse EE workspace\\MagazinSpring\\src\\main\\webapp\\resources\\uploads", fileName)));
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
    public String articolUploadSet(Model model, ArticolUpload articolUpload) {
		model.addAttribute("articolUpload", articolUpload); 	
		return "/admin/optiuni/adauga";
	}
	
    @RequestMapping(value="/admin/optiuni/articolUpload",method = RequestMethod.POST)
    public String articolUpload(Model model, @ModelAttribute("articolUpload")ArticolUpload articolUpload, Articole articol) throws IOException {
    	MultipartFile file = articolUpload.getFile();
    	if(articolUpload.isNotValid()) {
    		model.addAttribute("msg","Toate câmpurile sunt obligatorii");
    		return "admin/optiuni/adauga";
    	}
    	if (!file.getOriginalFilename().isEmpty()) {
			String fullFileName = file.getOriginalFilename();
		 	String fileName = fullFileName.substring(fullFileName.lastIndexOf("\\")+1, fullFileName.length());   	  
		 	final File folder = new File("E:\\Projects\\Eclipse EE workspace\\MagazinSpring\\src\\main\\webapp\\resources\\uploads");
		 	for (final File fileEntry : folder.listFiles()) {
			  if(fileEntry.getName().equals(fileName)) {
			     model.addAttribute("msg", "Fișierul există deja");
		         return "/admin/optiuni/adauga";
			  }
		 	}
		   	articol.setCategorie(articolUpload.getCategorie());
		   	articol.setDescriere(articolUpload.getDescriere());
		   	articol.setImagineURL("/resources/uploads/" + fileName);
		   	articol.setNume(articolUpload.getNume());
		   	articol.setPret(articolUpload.getPret());
		   	articolDAO.addArticol(articol);
	        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(
	                     						             new File("E:/Projects/Eclipse EE workspace/MagazinSpring/src/main/webapp/resources/uploads", fileName)));
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
    	model.addAttribute("articole",articolDAO.getArticole());
		model.addAttribute("mainQuery", mainQuery);	
		return "/admin/optiuni/stergere";
	}
    @RequestMapping(value="/admin/optiuni/stergere/cauta",method = RequestMethod.GET)
    public String deleteArticlePageSearch(Model model, @ModelAttribute("mainQuery")MainQuery mainQuery){
    	model.addAttribute("articole", articolDAO.getArticoleByMainQuery(mainQuery));
		model.addAttribute("mainQuery", mainQuery);	
		return "/admin/optiuni/stergere";
	}
    //adaugare cauta si la edit
    
	@RequestMapping(value="/admin/optiuni/sterge",method = RequestMethod.POST)
    public String deleteArticle(Model model, @RequestParam("id")String idStr) throws IOException {
		model.addAttribute("mainQuery", mainQuery);
		Articole articol = articolDAO.getArticolById(idStr);
	 	String fileURL = "E:\\Projects\\Eclipse EE workspace\\MagazinSpring\\src\\main\\webapp" + articol.getImagineURL();
	 	File file = new File(fileURL);
	 	System.out.println(fileURL);
	   	file.delete();
	   	int id = Integer.parseInt(idStr);
        articolDAO.deleteArticol(id);
        model.addAttribute("articole",articolDAO.getArticole());
     return "redirect:/admin/optiuni/stergere";
    }
}
