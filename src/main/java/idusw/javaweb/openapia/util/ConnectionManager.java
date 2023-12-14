package idusw.javaweb.openapia.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager{
    private static ConnectionManager instance = new ConnectionManager();
    private ConnectionManager() {}
    private static ConnectionManager getInstance(){return instance;}
    public Connection getConnection() {
        Connection conn = null;
        String dbName = "db_202012015";
        String jdbcUrl = "jdbc:mysql://localhost:3306/"+dbName+"?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
        String dbUser = "lsm";
        String dbPass = "1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver를 메모리에 적재
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } try {
            conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);  //dbms 연결

            /*
            rs = stmt.executeQuery("select * from member");
            System.out.println("Connection Success - " + jdbcUrl);
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.println(rs.getString(2));
            }
             */

        } catch(SQLException e) {
            System.out.println("Connection Fail - ");
        } finally {
            return conn;

        }
    }
}
