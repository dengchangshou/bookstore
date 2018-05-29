package pers.booksite.service;

import pers.booksite.dao.AllBooksDao;
import pers.booksite.vo.Book;
import pers.booksite.dao.BookDao;

import java.util.ArrayList;

public class BookService {
    private BookDao bookDao;
    private AllBooksDao allBooksDao;
    public BookService(){
        this.bookDao = new BookDao();
        this.allBooksDao = new AllBooksDao();
    }

    public ArrayList<Book> getAllBooks(){
        ArrayList allBooks = null;
        try {
            allBooks = allBooksDao.queryAllBooks();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allBooks;
    }

    public ArrayList<Book> getRandomBooks(){
        ArrayList randomBooks = null;
        try {
            randomBooks = allBooksDao.queryBooksByRandom();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return randomBooks;
    }

    public ArrayList<Book> getBooksByCategory(String category) {
        //测试getBooksByCategory是否被调用
//        System.out.println("getBooksByCategory 调用成功");
        ArrayList books = null;
        try {
            books = bookDao.queryCategoryBooks(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}
