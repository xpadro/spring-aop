package xpadro.spring.mvc.aop.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import xpadro.spring.mvc.aop.model.Order;


@Repository
public class OrderRepositoryImpl implements OrderRepository {
	private JdbcTemplate template;
	private RowMapper<Order> rowMapper = new OrderRowMapper();
	private static final String SEARCH = "select * from orders where orderId = ?";
	private static final String COLUMN_ID = "orderId";
	private static final String COLUMN_DESC = "description";
	
	public OrderRepositoryImpl() {}
	
	public OrderRepositoryImpl(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public Order getOrder(int id) {
		return template.queryForObject(SEARCH, rowMapper, id);
	}
	
	private class OrderRowMapper implements RowMapper<Order> {
		public Order mapRow(ResultSet rs, int i) throws SQLException {
			Order order = new Order();
			order.setOrderId(rs.getInt(COLUMN_ID));
			order.setDescription(rs.getString(COLUMN_DESC));
			
			return order;
		}
	}
}
