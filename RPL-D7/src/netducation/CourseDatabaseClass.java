/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netducation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDatabaseClass {
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
    
    public static List<Course> selectQueryCourse(){        
        List<Course> result = new ArrayList<>();
        String sql = "SELECT * FROM course";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("courseID"));
                c.setNama(rs.getString("nama"));
                c.setPoinMinimum(rs.getInt("minimumPoin"));
                c.setPoinDapat(rs.getInt("poinDapat"));
                result.add(c);
                //System.out.println("PRINTED FROM COURSE DB CLASS " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    
    public static List<Course> selectQueryCourse(String criteria){        
        List<Course> result = new ArrayList<>();
        String sql = "SELECT * FROM course WHERE nama LIKE '%" + criteria + "%' OR courseID LIKE '" + criteria + "%' ORDER BY poinDapat ASC";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("courseID"));
                c.setNama(rs.getString("nama"));
                c.setPoinMinimum(rs.getInt("minimumPoin"));
                c.setPoinDapat(rs.getInt("poinDapat"));
                result.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public static List<Course> selectQueryCourse(String criteria, String filter){        
        List<Course> result = new ArrayList<>();
        String sql = "SELECT * FROM course WHERE nama LIKE '%" + criteria + "%' OR courseID LIKE '" + criteria + "%' ORDER BY " + filter + " ASC";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("courseID"));
                c.setNama(rs.getString("nama"));
                c.setPoinMinimum(rs.getInt("minimumPoin"));
                c.setPoinDapat(rs.getInt("poinDapat"));
                result.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public static List<Course> selectQueryCourse(String criteria, String filter, String order){        
        List<Course> result = new ArrayList<>();
        String sql = "SELECT * FROM course WHERE nama LIKE '%" + criteria + "%' OR courseID LIKE '" + criteria + "%' ORDER BY " + filter + " " + order;
        System.out.println(sql);
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("courseID"));
                c.setNama(rs.getString("nama"));
                c.setPoinMinimum(rs.getInt("minimumPoin"));
                c.setPoinDapat(rs.getInt("poinDapat"));
                result.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public static Course selectQueryCourseSingular(String id){        
        Course result = new Course();
        String sql = "SELECT * FROM course WHERE courseID = '" + id + "'";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                result.setId(rs.getString("courseID"));
                result.setNama(rs.getString("nama"));
                result.setPoinMinimum(rs.getInt("minimumPoin"));
                result.setPoinDapat(rs.getInt("poinDapat"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public static void insertQueryCourse(String id, String nama, int poinMin, int poinDapat) {
        String sql = "INSERT INTO course(courseID,nama,minimumPoin,poinDapat) VALUES(?,?,?,?)";
        try (Connection conn = DatabaseClass.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, nama);
            pstmt.setInt(3, poinMin);
            pstmt.setInt(4, poinDapat);
            pstmt.executeUpdate();
            System.out.println("Course created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateQueryCourse(String id, String nama, int poinMin, int poinDapat) {
        String sql = "UPDATE course SET minimumPoin = ? , " 
                + "poinDapat = ? , "
                + "nama = ? "
                + "WHERE courseID = ?";
        try (Connection conn = DatabaseClass.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, poinMin);
            pstmt.setInt(2, poinDapat);
            pstmt.setString(3, nama);
            pstmt.setString(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void deleteQueryCourse(String id) {
        String sql = "DELETE FROM course WHERE courseID = ?";
        try (Connection conn = DatabaseClass.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
