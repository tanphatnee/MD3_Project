package ra.controller;

import ra.model.CartItem;
import ra.model.User;
import ra.service.CartService;

import java.util.List;

public class CartController {
    private CartService cartService;

    public CartController(User userLogin) {
        this.cartService = new CartService(userLogin);
    }

    public List<CartItem> findAll() {
        return cartService.findAll();
    }

    public void save(CartItem cartItem) {
        cartService.save(cartItem);
    }

    public void delete(Integer id) {
        cartService.delete(id);
    }

    public CartItem findById(Integer id) {
        return cartService.findById(id);
    }

    public int getNewId() {
        return cartService.getNewId();
    }

    public void clearAll() {
        cartService.clearAll();
    }
}

