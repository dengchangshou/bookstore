package pers.booksite.dao;

import pers.booksite.vo.Book;
import pers.booksite.vo.User;

import java.sql.*;
import java.util.ArrayList;

public class ManageUserDao {
    public static Connection conn;
    public static DBconnectDao db;
    public static PreparedStatement ptmt;
    public static Statement stat;
    public static ResultSet rs;
    static {
        db = new DBconnectDao();
    }

    /**
     * 删除用户
     * @param account
     */
    public void deleteUser(String account){
        try{
            db.openDB();
            conn = db.conn;
            stat = conn.createStatement();
            String sql = "delete from user where account = '" + account + "'";
            stat.execute(sql);
            stat.close();
            db.closeDB();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 修改用户信息
     * @param users
     * @param preAccount
     */
    public void updateUser(User users, String preAccount){
        try{
            db.openDB();
            conn = db.conn;
            stat = conn.createStatement();
            String sql = "select * from user";
            rs = stat.executeQuery(sql);
            while (rs.next()) {
//                System.out.println(preAccount);
//                System.out.println(rs.getString("account"));
                if (preAccount.equals(rs.getString("account"))) {
                    String sql0 = "UPDATE user set account = '" + users.getAccount() +
                                "', password = '" + users.getPassword() +
                                "' where account = '" + preAccount + "'";
//                    System.out.println(sql0);
                    stat.execute(sql0);
                    break;
                }
            }
            stat.close();
            rs.close();
            db.closeDB();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}

