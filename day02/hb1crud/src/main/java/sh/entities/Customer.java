package sh.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "customers")
public class Customer {
	@Id // primary key column
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	@Column//(name="mobile")
	private String mobile;
	@Column//(name="address")
	private String address;
	@Column(name="email", unique=true)
	private String email;
	//@Column(name="birth")
	private Date birth;
	@Transient // do not map this field to db column
	private int age;

	public Customer() {
	}

	public Customer(int id, String name, String password, String mobile, String address, String email, Date birth) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.birth = birth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, password=%s, mobile=%s, address=%s, email=%s, birth=%s]", id,
				name, password, mobile, address, email, birth);
	}
}
