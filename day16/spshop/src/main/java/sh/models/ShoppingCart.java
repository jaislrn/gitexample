package sh.models;

import java.util.List;

public interface ShoppingCart {

	List<Integer> getCart();

	void setCart(List<Integer> cart);

	void add(int id);

}