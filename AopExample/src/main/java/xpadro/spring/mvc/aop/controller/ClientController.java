package xpadro.spring.mvc.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xpadro.spring.mvc.aop.model.Client;
import xpadro.spring.mvc.aop.service.ClientService;

@Controller
public class ClientController {
	@Autowired
	private ClientService clientService;

	@RequestMapping("/getClients")
	public String getClients(Model model, @RequestParam("id") int id) {
		Client client = clientService.getClient(id);
		model.addAttribute("client", client);
		
		return "showClient";
	}	
}
