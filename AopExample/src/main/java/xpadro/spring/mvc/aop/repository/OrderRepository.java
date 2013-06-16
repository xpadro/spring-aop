package xpadro.spring.mvc.aop.repository;

import xpadro.spring.mvc.aop.model.Order;

public interface OrderRepository {
	public Order getOrder(int id);
}
