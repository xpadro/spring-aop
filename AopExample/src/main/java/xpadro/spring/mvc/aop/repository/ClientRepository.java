package xpadro.spring.mvc.aop.repository;

import xpadro.spring.mvc.aop.model.Client;

public interface ClientRepository {
	public Client getClient(int id);
}
