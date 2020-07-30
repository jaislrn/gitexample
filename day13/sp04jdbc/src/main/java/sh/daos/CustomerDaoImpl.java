package sh.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sh.entities.Customer;

class CustomerRowMapper implements RowMapper<Customer> {
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer c = new Customer();
		c.setId( rs.getInt("id") );
		c.setName( rs.getString("name") );
		c.setPassword( rs.getString("password") );
		c.setMobile( rs.getString("mobile") );
		c.setAddress( rs.getString("address") );
		c.setEmail( rs.getString("email") );
		c.setBirth( rs.getDate("birth") );
		return c;
	}
}

@Transactional
@Repository
public class CustomerDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT id, name, password, mobile, address, email, birth FROM customers WHERE email=?";
		Object[] args = {email};
		List<Customer> list = jdbcTemplate.query(sql, args, new CustomerRowMapper());
		if(list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	public List<Customer> findAllCustomers() {
		String sql = "SELECT id, name, password, mobile, address, email, birth FROM customers";
		List<Customer> list = jdbcTemplate.query(sql, new CustomerRowMapper());
		return list;
	}
	
	public int addCustomer(Customer cust) {
		String sql = "INSERT INTO customers(name, password, mobile, address, email, birth) VALUES(?, ?, ?, ?, ?, ?)";
		Object[] args = {cust.getName(), cust.getPassword(), cust.getMobile(), cust.getAddress(), cust.getEmail(), cust.getBirth()};
		int cnt = jdbcTemplate.update(sql, args);
		return cnt;
	}
}


