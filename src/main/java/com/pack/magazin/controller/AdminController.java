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
	
	@RequestMapping("/courses")
	public String getAdmins(Model model) {
		model.addAttribute("admins",adminDAO.getAdmins());
		return "admins";
	}
}
