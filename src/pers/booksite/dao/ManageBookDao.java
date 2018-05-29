package pers.booksite.dao;

import pers.booksite.vo.Book;

import java.sql.*;
import java.util.ArrayList;

public class ManageBookDao {
    public static Connection conn;
    public static DBconnectDao db;
    public static PreparedStatement ptmt;
    public static Statement stat;
    public static ResultSet rs;
    public static String[] category5 = {"children", "education", "novel", "science", "others"};
    static {
        db = new DBconnectDao();
    }
    public void addBook(Book book, String category) throws Exception {
        try {
            db.openDB();
            conn = db.conn;
            String sql = "insert into " + category + "(bookName, author, publish, price, bookImg, bookIntroduce, authorIntroduce) values(?,?,?,?,?,?,?)";
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, book.getBookName());
            ptmt.setString(2, book.getAuthor());
            ptmt.setString(3, book.getPublish());
            ptmt.setDouble(4, book.getPrice());
            ptmt.setString(5, book.getBookImg());
            ptmt.setString(6, book.getBookIntroduce());
            ptmt.setString(7, book.getAuthorIntroduce());
            ptmt.execute();
            ptmt.close();
            db.closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除书籍
    public void deleteBook(String bookName){
        try{
            db.openDB();
            conn = db.conn;
            stat = conn.createStatement();
//            DatabaseMetaData dbmd=conn.getMetaData();
//            boolean a = dbmd.supportsBatchUpdates();
//            System.out.println(a);
            conn.setAutoCommit(false);
            for(int i = 0; i < 5; i++){
                String sql = "delete from " + category5[i] + " where bookName='" + bookName +"'";
                stat.addBatch(sql);
            }
            stat.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
            stat.close();
            db.closeDB();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //修改书籍
    public void updateBook(Book book, String preBookName){
        try{
            db.openDB();
            conn = db.conn;
            stat = conn.createStatement();
            String sql = "select * from children union select * from novel union  select * from education union select * from science union select * from others";
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                if (preBookName.equals(rs.getString("bookName"))) {
                    conn.setAutoCommit(false);
                    for(int i = 0; i < 5; i++){
                        String sql0 = "UPDATE " + category5[i] + " set bookName = '" + book.getBookName() +
                                "', author = '" + book.getAuthor() +
                                "', publish = '" + book.getPublish() +
                                "', price = '" + book.getPrice() +
                                "', bookImg = '" + book.getBookImg() +
                                "', bookIntroduce = '" + book.getBookIntroduce() +
                                "', authorIntroduce = '" + book.getAuthorIntroduce() +
                                "' where bookName = '" + preBookName + "'";
                        stat.addBatch(sql0);
                    }
                    stat.executeBatch();
                    conn.commit();
                    conn.setAutoCommit(true);
                    break;
                }
            }
            rs.close();
            stat.close();
            db.closeDB();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
