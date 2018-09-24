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
import com.pack.magazin.entity.Articol;
import com.pack.magazin.model.ArticolUpload;

@Controller
public class ArticolController {
	@Autowired
	ArticolDAO articolDAO;
	@Autowired
	Articol articol;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("articole",articolDAO.getArticole());
		return "index";
	}
	
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
	
    @RequestMapping(value="admin/optiuni/articolUpload",method = RequestMethod.POST)
    public String articolUpload(Model model, @ModelAttribute("articolUpload")ArticolUpload articolUpload) throws IOException {
    	MultipartFile file = articolUpload.getFile();
    	if(articolUpload.isNotValid()) {
    		model.addAttribute("msg","Toate câmpurile sunt obligatorii");
    		return "admin/optiuni/adauga";
    	}
    	if (!file.getOriginalFilename().isEmpty()) {
			String fullFileName = file.getOriginalFilename();
		 	String fileName = fullFileName.substring(fullFileName.lastIndexOf("\\")+1, fullFileName.length());   	  
		 	final File folder = new File("E:/mytemp");
		 	for (final File fileEntry : folder.listFiles()) {
			  if(fileEntry.getName().equals(fileName)) {
			     model.addAttribute("msg", "Fișierul există deja");
		         return "admin/optiuni/adauga";
			  }
		 	}
		   	articol.setCategorie(articolUpload.getCategorie());
		   	articol.setDescriere(articolUpload.getDescriere());
		   	articol.setImagineURL("E:\\mytemp\\" + fileName);
		   	articol.setNume(articolUpload.getNume());
		   	articol.setPret(articolUpload.getPret());
		   	articolDAO.addArticol(articol);
	        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(
	                     						             new File("E:/mytemp", fileName)));
	        outputStream.write(file.getBytes());
	        outputStream.flush();
	        outputStream.close();
	        model.addAttribute("msg", "articol adăugat");
      } else {
          model.addAttribute("msg", "Selectează un fișier");
     }
     return "admin/optiuni/adauga";
    }
}
