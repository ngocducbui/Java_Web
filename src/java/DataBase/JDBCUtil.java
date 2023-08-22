/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.DriverManager;
//import com.mysql.jdbc.Driver;
import java.sql.Connection;

import com.mysql.cj.jdbc.Driver;
/**
 *
 * @author ADMIN
 */
public class JDBCUtil {

    public static Connection getConnection() {
        Connection c = null;
        try {
            DriverManager.registerDriver((java.sql.Driver) new Driver());
            final String url = "jdbc:mySQL://localhost:3307/mywebsite";
            final String username = "root";
            final String password = "123456";
            c = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection(final Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(final Connection c) {
        try {
            if (c != null) {
                final DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
