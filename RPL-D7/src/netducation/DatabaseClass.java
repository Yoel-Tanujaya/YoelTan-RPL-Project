/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netducation;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseClass {
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:sqlite/net.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            //System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
        return conn;
    }
    
    public static void createNewDatabase(String fileName) {
 
        String url = "jdbc:sqlite:sqlite/" + fileName;
        File file = new File ("sqlite/" + fileName);
        if (file.exists()) {
            System.out.println("Database already exists");
        }
        else {
            try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:sqlite/net.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	username varchar2 PRIMARY KEY,\n"
                + "	email varchar2 NOT NULL,\n"
                + "	password varchar2 NOT NULL,\n"
                + "	point integer,\n"
                + "	role integer\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Users selectQueryUsersSingular(String user){        
        Users result = new Users();
        String sql = "SELECT * FROM users WHERE username='" + user + "'";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                result.setUsername(rs.getString("username"));
                result.setPassword(rs.getString("password")); 
                result.setEmail(rs.getString("email"));
                result.setPoint(rs.getInt("point"));
                result.setRole(rs.getInt("role"));
            }
        } catch (SQLException e) {
            System.out.println("User DB Class "+e.getMessage());
        }
        return result;
    }
    
    public static List<Users> selectQueryUsersLists(){        
        List<Users> result = new ArrayList<>();
        Users objectUser = new Users();
        String sql = "SELECT username, password, email FROM users";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                objectUser.setUsername(rs.getString("username"));
                objectUser.setPassword(rs.getString("password"));
                objectUser.setEmail(rs.getString("email"));
                result.add(objectUser);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public static void insertQuery(String user, String pass, String email, int role) {
        String sql = "INSERT INTO users(username,email,password,point,role) VALUES(?,?,?,?,?)";
        try (Connection conn = DatabaseClass.connect(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user);
            pstmt.setString(2, email);
            pstmt.setString(3, pass);
            pstmt.setInt(4, 0);
            pstmt.setInt(5, role);
            pstmt.executeUpdate();
            System.out.println("User created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateQueryAll(String user, String pass, String email) {
        String sql = "UPDATE users SET username = ? , "
                + "email = ? , "
                + "password = ? " 
                + "WHERE username = ?";
        try (Connection conn = DatabaseClass.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user);
            pstmt.setString(2, email);
            pstmt.setString(3, pass);
            pstmt.setString(4, user);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ALL "+e.getMessage());
        }
    }
    
    public static void updateQueryUsername(String user, String pass, String email) {
        String sql = "UPDATE users SET username = ? , " 
                + "password = ? "
                + "WHERE email = ?";
        try (Connection conn = DatabaseClass.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("UNAME "+e.getMessage());
        }
    }
    
    public static void updateQueryEmail(String user, String pass, String email) {
        String sql = "UPDATE users SET email = ? , "
                + "password = ? " 
                + "WHERE username = ?";
        try (Connection conn = DatabaseClass.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, pass);
            pstmt.setString(3, user);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("EMAIL "+e.getMessage());
        }
    }
    
    public static void updateQueryPassword(String user, String pass) {
        String sql = "UPDATE users SET password = ? "
                + "WHERE username = ?";
        try (Connection conn = DatabaseClass.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pass);
            pstmt.setString(2, user);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("PASS "+e.getMessage());
        }
    }
    
    public static void deleteQuery(String user) {
        String sql = "DELETE FROM users WHERE username = ?";
        try (Connection conn = DatabaseClass.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updatePoint(String user, int poin) {
        String sql = "UPDATE users SET point = point + ? "
                + "WHERE username = ?";
        try (Connection conn = DatabaseClass.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, poin);
            pstmt.setString(2, user);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("PASS "+e.getMessage());
        }
    }
}
