package sh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customers")
public class Customer {
	//@GeneratedValue(generator = "my_ids", strategy = GenerationType.AUTO)
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
//	@TableGenerator(name = "gen", table = "id_gen", initialValue = 1000, 
//			pkColumnName = "pkcol", valueColumnName = "id", allocationSize = 2)
//	@GeneratedValue(generator = "gen", strategy = GenerationType.TABLE)

	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String mobile;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobile=" + mobile + "]";
	}
	
}
