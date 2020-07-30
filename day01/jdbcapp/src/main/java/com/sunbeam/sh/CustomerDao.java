package com.sunbeam.sh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements AutoCloseable {
	private Connection con;
	public void open() throws Exception {
		con = DriverManager.getConnection(JdbcUtil.DB_URL, JdbcUtil.DB_USER, JdbcUtil.DB_PASSWORD);
	}
	public void close() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
	}
	
	public Customer findCustomer(String email) throws Exception {
		String sql = "SELECT id, name, password, mobile, address, email, birth FROM customers WHERE email=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Customer> findAll() throws Exception {
		List<Customer> list = new ArrayList<>();
		String sql = "SELECT id, name, password, mobile, address, email, birth FROM customers";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Customer c = new Customer();
				c.setId( rs.getInt("id") );
				c.setName( rs.getString("name") );
				c.setPassword( rs.getString("password") );
				c.setMobile( rs.getString("mobile") );
				c.setAddress( rs.getString("address") );
				c.setEmail( rs.getString("email") );
				c.setBirth( rs.getDate("birth") );
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int addCustomer(Customer c) throws Exception {
		String sql = "INSERT INTO customers(name, password, mobile, address, email, birth) VALUES(?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getPassword());
			stmt.setString(3, c.getMobile());
			stmt.setString(4, c.getAddress());
			stmt.setString(5, c.getEmail());
			stmt.setDate(6, c.getBirth());

			int cnt = stmt.executeUpdate();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int updateCustomer(Customer c) throws Exception {
		String sql = "UPDATE customers SET name=?, password=?, mobile=?, address=?, email=?, birth=? WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getPassword());
			stmt.setString(3, c.getMobile());
			stmt.setString(4, c.getAddress());
			stmt.setString(5, c.getEmail());
			stmt.setDate(6, c.getBirth());
			stmt.setInt(7, c.getId());
			int cnt = stmt.executeUpdate();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int deleteCustomer(Customer c) throws Exception {
		String sql = "DELETE FROM customers WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, c.getId());
			int cnt = stmt.executeUpdate();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
