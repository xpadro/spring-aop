package xpadro.spring.mvc.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xpadro.spring.mvc.aop.model.Order;
import xpadro.spring.mvc.aop.repository.OrderRepository;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Order getOrder(int id) {
		return orderRepository.getOrder(id);
	}
}
