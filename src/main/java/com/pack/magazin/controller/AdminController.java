package com.pack.magazin.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pack.magazin.dao.AdminDAO;

@Controller
public class AdminController {
	@Autowired
	AdminDAO adminDAO;
	
	@RequestMapping(value="admin", method=RequestMethod.POST)
	public String getAdmins(Model model) {
		return "admin/optiuni/index";
	}
	@RequestMapping(value="admin", method=RequestMethod.GET)
	public String adminPage() {
		return "admin/index";
	}
}
