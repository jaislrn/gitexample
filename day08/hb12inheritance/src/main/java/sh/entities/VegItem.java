package sh.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Veg")
public class VegItem extends Item {
	@Override
	public String toString() {
		return "VegItem -- " + super.toString();
	}
}
