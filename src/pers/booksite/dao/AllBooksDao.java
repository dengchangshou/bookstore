package pers.booksite.dao;

import pers.booksite.vo.Book;

import java.sql.*;
import java.util.ArrayList;

public class AllBooksDao {
    public ArrayList queryAllBooks() throws Exception {
        //判断queryAllBooks是否被调用
        //System.out.println("queryAllBooks调用成功");
        Connection conn = null;
        ArrayList<Book> allBooks = new ArrayList();
        try {
            DBconnectDao db = new DBconnectDao();
            db.openDB();
            conn = db.conn;
            String sql = "select * from children union select * from novel union  select * from education union select * from science union select * from others";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            int i = 1;
            while (rs.next()) {
                Book book = new Book();
                book.setBookID(Integer.toString(i));
                book.setBookName(rs.getString("bookName"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getFloat("price"));
                book.setPublish(rs.getString("publish"));
                book.setBookImg(rs.getString("bookImg"));
                book.setAuthorIntroduce(rs.getString("authorIntroduce"));
                book.setBookIntroduce(rs.getString("bookIntroduce"));
                allBooks.add(book);
                i++;
            }
            rs.close();
            stat.close();
            db.closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allBooks;
    }

    public ArrayList queryBooksByRandom() throws Exception {
        Connection conn = null;
        ArrayList<Book> randomBooks = new ArrayList();
        try {
            DBconnectDao db = new DBconnectDao();
            db.openDB();
            conn = db.conn;
            String sql = "select * from children union select * from novel union  select * from education union select * from science union select * from others limit 12";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            int i = 1;
            while (i <= 12 && rs.next()) {
                Book book = new Book();
                book.setBookName(rs.getString("bookName"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getFloat("price"));
                book.setPublish(rs.getString("publish"));
                book.setBookImg(rs.getString("bookImg"));
                book.setAuthorIntroduce(rs.getString("authorIntroduce"));
                book.setBookIntroduce(rs.getString("bookIntroduce"));
                randomBooks.add(book);
                i++;
            }
            rs.close();
            stat.close();
            db.closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return randomBooks;
    }
}
