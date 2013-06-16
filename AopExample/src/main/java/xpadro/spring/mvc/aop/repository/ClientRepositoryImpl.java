package xpadro.spring.mvc.aop.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import xpadro.spring.mvc.aop.model.Client;


@Repository
public class ClientRepositoryImpl implements ClientRepository {
	private JdbcTemplate template;
	private RowMapper<Client> rowMapper = new ClientRowMapper();
	private static final String SEARCH = "select * from clients where clientId = ?";
	private static final String COLUMN_ID = "clientId";
	private static final String COLUMN_NAME = "name";
	
	public ClientRepositoryImpl() {}
	
	public ClientRepositoryImpl(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public Client getClient(int id) {
		return template.queryForObject(SEARCH, rowMapper, id);
	}
	
	private class ClientRowMapper implements RowMapper<Client> {
		public Client mapRow(ResultSet rs, int i) throws SQLException {
			Client client = new Client();
			client.setClientId(rs.getInt(COLUMN_ID));
			client.setName(rs.getString(COLUMN_NAME));
			
			return client;
		}
	}
}
