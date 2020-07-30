package sh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "qryBooksOfPriceGT", query = "from Book b where b.price >= :p_price"),
	@NamedQuery(name = "qryBooksOfPriceLT", query = "from Book b where b.price <= :p_price")
})
@NamedNativeQuery(name = "spBooksInRange", 
	query = "CALL books_in_range(:p1,:p2)",
	hints = {@QueryHint(name="org.hibernate.callable", value="true")},
	resultClass = Book.class
)
@Entity
@Table(name="books")
public class Book {
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String author;
	@Column
	private String subject;
	@Column
	private double price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name, String author, String subject, double price) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", subject=" + subject + ", price=" + price
				+ "]";
	}
	
}
