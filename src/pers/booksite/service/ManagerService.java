package pers.booksite.service;

import pers.booksite.dao.ManageBookDao;
import pers.booksite.dao.ManageUserDao;
import pers.booksite.vo.Book;
import pers.booksite.vo.User;

public class ManagerService {
    private ManageBookDao manageBookDao;
    private ManageUserDao manageUserDao;
    public ManagerService(){
        this.manageBookDao = new ManageBookDao();
        this.manageUserDao = new ManageUserDao();
    }

    public void addBook(Book book, String category) {
        try {
            manageBookDao.addBook(book, category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(String bookName) {
        try {
            manageBookDao.deleteBook(bookName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Book book, String preBookName) {
        try {
            manageBookDao.updateBook(book, preBookName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String userName) {
        try {
            manageUserDao.deleteUser(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user, String preAccount) {
        try {
            manageUserDao.updateUser(user, preAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
