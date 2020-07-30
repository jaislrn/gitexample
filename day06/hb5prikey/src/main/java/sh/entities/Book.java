package sh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "books")
public class Book {
	@TableGenerator(name = "gen", table = "id_gen", initialValue = 1000, 
			pkColumnName = "pkcol", valueColumnName = "id", allocationSize = 1)
	@GeneratedValue(generator = "gen", strategy = GenerationType.TABLE)
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String author;
	// ...
}
