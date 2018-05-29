package pers.booksite.dao;

import pers.booksite.vo.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookDao {
    public ArrayList queryCategoryBooks(String category) throws Exception {
        //判断queryCategoryBooks是否被调用
        //System.out.println("queryCategoryBooks调用成功");
        Connection conn = null;
        ArrayList<Book> bookList = new ArrayList();
        try {
            DBconnectDao db = new DBconnectDao();
            db.openDB();
            conn = db.conn;
            String sql = "select * from " + category;
//            System.out.println(sql);
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                Book book = new Book();
                book.setBookID(rs.getString("bookID"));
                book.setBookName(rs.getString("bookName"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getFloat("price"));
                book.setPublish(rs.getString("publish"));
                book.setBookImg(rs.getString("bookImg"));
                book.setAuthorIntroduce(rs.getString("authorIntroduce"));
                book.setBookIntroduce(rs.getString("bookIntroduce"));
                bookList.add(book);
            }
            stat.close();
            rs.close();
            stat.close();
            db.closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
