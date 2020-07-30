package sh.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(scopeName = "session", proxyMode = ScopedProxyMode.INTERFACES)
@Component
public class ShoppingCartImpl implements ShoppingCart {
	private List<Integer> cart;
	
	public ShoppingCartImpl() {
		this.cart = new ArrayList<Integer>();
	}

	@Override
	public List<Integer> getCart() {
		return cart;
	}

	@Override
	public void setCart(List<Integer> cart) {
		this.cart = cart;
	}
	
	@Override
	public void add(int id) {
		this.cart.add(id);
	}

	@Override
	public String toString() {
		return "ShoppingCart [cart=" + cart + "]";
	}
}
