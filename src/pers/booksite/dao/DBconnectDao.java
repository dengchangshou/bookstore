package pers.booksite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnectDao {
    public Connection conn = null;
    public DBconnectDao(){

    }

    public void openDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite::resource:booksite.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeDB(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
