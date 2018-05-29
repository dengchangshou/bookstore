package pers.booksite.dao;

import pers.booksite.vo.Cart;
import pers.booksite.vo.Order;

import java.sql.*;
import java.util.ArrayList;

public class CartDao {
    public static Connection conn;
    public static DBconnectDao db;
    public static PreparedStatement ptmt;
    public static Statement stat;
    public static ResultSet rs;
    static {
        db = new DBconnectDao();
    }

    //添加图书到购物车
    public void addCart(Cart cart) throws Exception {
        try {
            db.openDB();
            conn = db.conn;
            String sql = "select * from cart";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            boolean ok = true;
            while (rs.next()){
                if(rs.getString("user").equals(cart.getUser()) && rs.getString("bookName").equals(cart.getBookName())){
                    ok = false;
                    stat.close();
                    rs.close();
                    updateCart(cart);
                    break;
                }
            }
            if(ok){
//                System.out.println(cart.getBookName());
                sql = "insert into cart(user, bookImg, bookName, bookPrice, count, totalPrice) values(?,?,?,?,?,?)";
                ptmt = conn.prepareStatement(sql);
                ptmt.setString(1, cart.getUser());
                ptmt.setString(2, cart.getBookImg());
                ptmt.setString(3, cart.getBookName());
                ptmt.setDouble(4, cart.getBookPrice());
                ptmt.setInt(5, cart.getCount());
                ptmt.setDouble(6, cart.getTotalPrice());
                ptmt.execute();
                ptmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs.close();
//        stat.close();
        db.closeDB();
    }

    //从购物车删除图书
    public void deleteBook(String user, String  bookName){
        try{
            db.openDB();
            conn = db.conn;
            stat = conn.createStatement();
            String sql = "delete from cart where bookName='" + bookName + "' AND user='" + user +"'";
            stat.execute(sql);
//            stat.close();
            db.closeDB();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //修改购物车
    public void updateCart(Cart cart) throws SQLException {
        try{
            db.openDB();
            stat.close();
            conn = db.conn;
            stat = conn.createStatement();
            String sql = "select * from cart";
//            rs.close();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                if (cart.getUser().equals(rs.getString("user")) && cart.getBookName().equals(rs.getString("bookName"))) {
                    sql = "UPDATE cart set count = count+1, totalPrice = (count + 1) * bookPrice where bookName = '" + cart.getBookName() + "'";
                    stat.executeUpdate(sql);
                    break;
                }
            }
            stat.close();
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            db.closeDB();
        }
    }

    //生成订单
    public void createOrder(Order order, ArrayList<Cart> carts) throws Exception {
        try {
            db.openDB();
            conn = db.conn;
            stat = conn.createStatement();
            boolean exitUser = false;
            String sql = "select * from orderCart";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                if(order.getUserName().equals(rs.getString("user"))){
                    exitUser = true;
                    break;
                }
            }
            if(!exitUser){ //用户不存在
                sql = "insert into orderCart(user) values('" + order.getUserName() + "')";
                stat.executeUpdate(sql);
            }
            sql = "DELETE FROM orderInfo WHERE user = '" + order.getUserName() + "'";
            stat.executeUpdate(sql);
            sql = "insert into orderInfo(user, bookName, bookPrice, count, totalPrice) values(?,?,?,?,?)";
            ptmt = conn.prepareStatement(sql);
            for(Cart c:carts){
                ptmt.setString(1, c.getUser());
                ptmt.setString(2, c.getBookName());
                ptmt.setDouble(3, c.getBookPrice());
                ptmt.setInt(4, c.getCount());
                ptmt.setDouble(5, c.getTotalPrice());
                ptmt.addBatch();
            }
            ptmt.executeBatch();
            ptmt.clearBatch();
            ptmt.close();
            sql = "delete from cart where user='" + order.getUserName() + "'";
            stat.executeUpdate(sql);
            stat.close();
            db.closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //显示购物车
    public ArrayList showCart(String userName){
        ArrayList<Cart> carts = new ArrayList();
        try {
            db.openDB();
            conn = db.conn;
            stat = conn.createStatement();
            String sql = "select * from cart where user='" + userName + "'";
//            System.out.println(sql);
            rs = stat.executeQuery(sql);
            while(rs.next()){
                Cart cart = new Cart();
                cart.setBookName(rs.getString("bookName"));
                cart.setUser(rs.getString("user"));
                cart.setBookImg(rs.getString("bookImg"));
                cart.setBookPrice(rs.getDouble("bookPrice"));
                cart.setCount(rs.getInt("count"));
                cart.setTotalPrice(rs.getDouble("totalPrice"));
                carts.add(cart);
            }
            rs.close();
            stat.close();
            db.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
        return carts;
    }

    //显示订单
    public ArrayList showOrder(String userName){
        ArrayList<Cart> orderCart = new ArrayList();
        try {
            db.openDB();
            conn = db.conn;
            stat = conn.createStatement();
            String sql = "select * from orderInfo where user='" + userName + "'";
//            System.out.println(sql);
            rs = stat.executeQuery(sql);
            while(rs.next()){
                Cart cart = new Cart();
                cart.setBookName(rs.getString("bookName"));
                cart.setUser(rs.getString("user"));
                cart.setBookPrice(rs.getDouble("bookPrice"));
                cart.setCount(rs.getInt("count"));
                cart.setTotalPrice(rs.getDouble("totalPrice"));
//                System.out.println(cart.getBookName());
                orderCart.add(cart);
            }
            rs.close();
            stat.close();
            db.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderCart;
    }
}
