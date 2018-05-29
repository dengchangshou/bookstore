package pers.booksite.service;

import pers.booksite.dao.CartDao;
import pers.booksite.vo.Cart;
import pers.booksite.vo.Order;

import java.util.ArrayList;

public class CartService {
    private CartDao cartDao;

    public CartService() {
        this.cartDao = new CartDao();
    }

    public void addCart(Cart cart){
        ArrayList cartList = null;
        try {
            cartDao.addCart(cart);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteBook(String user, String bookName) {
        try {
            cartDao.deleteBook(user,bookName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Cart cart) {
        try {
            cartDao.updateCart(cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList showCart(String userName){
        ArrayList<Cart> cart = new ArrayList<>();
        try {
            cart = cartDao.showCart(userName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cart;
    }

    public void createOrder(Order order, ArrayList<Cart> carts){
        try{
            cartDao.createOrder(order, carts);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList showOrder(String userName){
        ArrayList<Cart> cart = new ArrayList<>();
        try {
            cart = cartDao.showOrder(userName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cart;
    }
}
