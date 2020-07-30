package sh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="images")
public class Image {
	@Id
	@Column
	private int id;
	@Lob
	@Column
	private byte[] image;
	
	public Image() {
	}

	public Image(int id, byte[] image) {
		this.id = id;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return String.format("Image [id=%s]", id);
	}
}
