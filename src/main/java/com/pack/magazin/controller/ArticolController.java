package com.pack.magazin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.pack.magazin.dao.ArticolDAO;
import com.pack.magazin.model.ArticolUpload;

@Controller
public class ArticolController {
	@Autowired
	ArticolDAO articolDAO;
	
	@RequestMapping(value="admin/optiuni/adauga",method = RequestMethod.GET)
	   public String articolUpload(Model model) {
		 //model.addAttribute("articolUpload", articolUpload); 	
	     return "admin/optiuni/adauga";
	}
    @RequestMapping(value="admin/optiuni/articolUpload",method = RequestMethod.POST)
    public String articolUpload(Model model, @RequestParam("file") MultipartFile file) throws IOException {
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
          BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(
                     						             new File("E:/mytemp", fileName)));
          outputStream.write(file.getBytes());
          outputStream.flush();
          outputStream.close();
          model.addAttribute("msg", "Articol adăugat");
     } else {
          model.addAttribute("msg", "Selectează un fișier");
     }
     return "admin/optiuni/adauga";
   }
}
