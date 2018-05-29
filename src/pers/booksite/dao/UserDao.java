package pers.booksite.dao;

import pers.booksite.vo.User;
import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    public static Connection conn;
    public static DBconnectDao db;
    public static PreparedStatement ptmt;
    public static Statement stat;
    public static ResultSet rs;
    static {
        db = new DBconnectDao();
    }

    /**
     * 查找用户
     * @param account
     * @return
     * @throws Exception
     */
    public String searchUser(String account) throws Exception{
        String pw = null;
        try {
            db.openDB();
            conn = db.conn;
//            DBconnectDao db = new DBconnectDao();
//            db.openDB();
//            conn = db.conn;
            String sql = "select * from user";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()){
//                System.out.println(rs.getString("account"));
                if(account.equals(rs.getString("account"))){
                    pw = "用户已注册！";
                    break;
                }
            }
//
            rs.close();
            stat.close();
            db.closeDB();
        } catch (Exception e){
            e.printStackTrace();
        }
        return pw;
    }

    public ArrayList getAllUsers() throws Exception {
        ArrayList<User> allUsers = new ArrayList();
        try {
            db.openDB();
            conn = db.conn;
            String sql = "select * from user";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setAccount(rs.getString("account"));
                user.setPassword(rs.getString("password"));
                allUsers.add(user);
            }
            stat.close();
            rs.close();
            db.closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    /**
     * 注册用户
     * @param user
     * @throws Exception
     */
    public void addUser(User user) throws Exception {
        try {
            db.openDB();
            conn = db.conn;
            String sql = "insert into user(account, password) values(?,?)";
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, user.getAccount());
            ptmt.setString(2, user.getPassword());
            ptmt.execute();
            ptmt.close();
            db.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 验证用户
     * @param user
     * @return
     * @throws Exception
     */
    public String confirmUser(User user) throws Exception{
        String pw = null;
        try {
            db.openDB();
            conn = db.conn;
            String sql = "select * from user";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()){
//                System.out.println(rs.getString("account"));
                if(user.getAccount().equals(rs.getString("account")) && user.getPassword().equals(rs.getString("password"))){
                    pw = "登录成功！";
                    break;
                }
            }
//
            rs.close();
            stat.close();
            db.closeDB();
        } catch (Exception e){
            e.printStackTrace();
        }
        return pw;
    }
}