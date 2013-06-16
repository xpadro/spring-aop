package xpadro.spring.mvc.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xpadro.spring.mvc.aop.model.Order;
import xpadro.spring.mvc.aop.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping("/getOrders")
	public String getOrders(Model model, @RequestParam("id") int id) {
		Order order = orderService.getOrder(id);
		model.addAttribute("order", order);
		
		return "showOrder";
	}
}
