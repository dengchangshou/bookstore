package pers.booksite.service;

import pers.booksite.dao.UserDao;
import pers.booksite.vo.User;

import java.util.ArrayList;

public class UserService {
    private UserDao userDao;
    public UserService(){
        this.userDao = new UserDao();
    }

    /**
     * 查找账号是否存在
     * @param account
     * @return
     */
    public String searchUsers(String account){
        String userAccount = null;
        try{
            userAccount = userDao.searchUser(account);
        }catch (Exception e){
            e.printStackTrace();
        }
        return userAccount;
    }

    /**
     * 查找所有用户
     * @return
     */
    public ArrayList<User> getAllUsers(){
        ArrayList allUsers = null;
        try {
            allUsers = userDao.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    /**
     * 注册账号
     * @param user
     */
    public void addUser(User user) {
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证账号密码
     * @param user
     * @return
     */
    public String confirmUser(User user){
        String success = null;
        try{
            success = userDao.confirmUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return success;
    }
}
