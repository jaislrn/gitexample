package sh.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartBean {
	private String[] book; // book ids from books page
	private List<Integer> cart; // book ids in cart
	public CartBean() {
		this.book = new String[0];
		this.cart = new ArrayList<Integer>();
	}
	public String[] getBook() {
		return book;
	}
	public void setBook(String[] book) {
		this.book = book;
	}
	public List<Integer> getCart() {
		return cart;
	}
	public void setCart(List<Integer> cart) {
		this.cart = cart;
	}
	public void addToCart() {
		for (String bookId : book) {
			int id = Integer.parseInt(bookId);
			this.cart.add(id);
		}
	}
}
