package com.pack.magazin.controller;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pack.magazin.dao.ClientsDAO;
import com.pack.magazin.entity.Clients;

@Controller
public class ClientsController {
	@Autowired
	ClientsDAO clientsDAO;
	
	@RequestMapping(value="/inregistrare", method = RequestMethod.GET)
	public String inregPage(Clients client, Model model) {
		model.addAttribute("client", client);
		return "/inregistrare";
	}
	
	@RequestMapping(value="/inregistrare",method = RequestMethod.POST)
    public String inreg(Model model, @ModelAttribute("client")Clients client, HttpServletRequest request) {
		model.addAttribute("client", client);
    	if (client.isNotValid()) {
			     model.addAttribute("msg", "Toate câmpurile sunt obligatorii");
		         return "/inregistrare";
		}
    	if(!client.getPassword().equals(request.getParameter("confirmation"))) {
    		model.addAttribute("msg", "Parolele nu corespund.");
    		return "/inregistrare";
    	}
    	Clients clientBaza = clientsDAO.getClientByEmail(client.getEmail());
    	if(clientBaza==null) {
    		model.addAttribute("msg", "Adresa de email există deja.");
    		return "/inregistrare";
    	}
    	
		clientsDAO.addClient(client);
		model.addAttribute("msg", "Ați fost înregistrat cu succes.");
	    return "/intra";
    }
	
	@RequestMapping(value="/intra", method = RequestMethod.GET)
	public String intraPage(Clients client, Model model, HttpServletRequest request) {
		model.addAttribute("client", client);
		return "/intra";
	}
	
	@RequestMapping(value="/intra",method = RequestMethod.POST)
    public String intra(Model model, @ModelAttribute("client")Clients client, HttpServletResponse response,
    		HttpServletRequest request) {
		Clients clientBaza = clientsDAO.getClientByEmail(client.getEmail());
    	if (clientBaza.getEmail().equals(client.getEmail())&&!client.getEmail().isEmpty()) {
    		if(clientBaza.getPassword().equals(client.getPassword())){
	    		HttpSession session1 = request.getSession();
	    		session1.invalidate();
	    		HttpSession session = request.getSession();
	    		session.setAttribute("user", clientBaza);
	    		Cookie cookie = new Cookie("clientId", clientBaza.getId()+"");
	    		cookie.setMaxAge(300);
	    		response.addCookie(cookie);
			    return "redirect:/";
    		}
		}
	    model.addAttribute("msg", "Adresa de email nu corespunde cu parola");
	    return "/intra";
    }
	@RequestMapping(value="/recuperare", method = RequestMethod.GET)
	public String recoveryPage(Clients client, Model model) {
		model.addAttribute("client", client);
		return "/recuperare";
	}
	@RequestMapping(value="/recuperare",method = RequestMethod.POST)
    public String rec(Model model, @ModelAttribute("client")Clients client, Clients clientForm) {
		Clients clientBaza = clientsDAO.getClientByEmail(client.getEmail());
		model.addAttribute("client", clientForm);
		String email = clientBaza.getEmail();
    	if (!email.isEmpty()) {
    		
    		final String username = "alextestmail.12@gmail.com";
    		final String password = "parola.12";
    		Properties props = new Properties();
    		props.put("mail.smtp.host", "smtp.gmail.com");
    		props.put("mail.smtp.socketFactory.port", "465");
    		props.put("mail.smtp.socketFactory.class",
    				"javax.net.ssl.SSLSocketFactory");
    		props.put("mail.smtp.auth", "true");
    		props.put("mail.smtp.port", "465");

    		Session session = Session.getDefaultInstance(props,
    			new javax.mail.Authenticator() {
    				protected PasswordAuthentication getPasswordAuthentication() {
    					return new PasswordAuthentication(username,password);
    				}
    			});
    		try {
    			Message message = new MimeMessage(session);
    			message.setFrom(new InternetAddress(username));
    			message.setRecipients(Message.RecipientType.TO,
    					InternetAddress.parse(email));
    			message.setSubject("Parola");
    			message.setText("Parola: " + clientBaza.getPassword());
    			Transport.send(message);
    		} catch (MessagingException e) {
    			throw new RuntimeException(e);
    		}
    	
    		model.addAttribute("msg", "Parola a fost trimisă pe adresa de email.");
			return "/intra";
		}
	    model.addAttribute("msg", "Adresa de email nu există.");
	    return "/recuperare";
    }
}
