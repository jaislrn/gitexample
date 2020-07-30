package sh.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NonVeg")
public class NonVegItem extends Item {
	@Override
	public String toString() {
		return "NonVegItem -- " + super.toString();
	}
}
