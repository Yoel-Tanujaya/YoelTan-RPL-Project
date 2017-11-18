/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netducation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDatabaseClass {   
    
    //QUERY UNTUK SELECT SEMUA COURSE YANG ADA DALAM DATABASE, TANPA CRITERIA ATAU PARAMETER KHUSUS, HANYA SELECT ALL FORM COURSE SAJA
    public static List<Course> selectQueryCourse(){        
        List<Course> result = new ArrayList<>();
        String sql = "SELECT * FROM course";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("courseID"));
                c.setLanguage(rs.getString("language"));
                c.setNama(rs.getString("nama"));
                c.setPoinMinimum(rs.getInt("minimumPoin"));
                c.setPoinDapat(rs.getInt("poinDapat"));
                c.setTeacher(rs.getString("teacher"));
                result.add(c);
                //System.out.println("PRINTED FROM COURSE DB CLASS " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
            }
        } catch (SQLException e) {
            System.out.println("Course DB Class "+e.getMessage());
        }
        return result;
    }
    
    //SELECT COURSE BERDASARKAN CRITERIA DARI SEARCH TEXT FIELD, YANG DICARI BISA NAMA COURSE, ID COURSE, ATAU NAMA PENGAJAR. DEFAULT UNTUK QUERY INI DI URUTKAN BERDASARKAN POIN YANG BISA DI DAPATKAN OLEH USER SECARA ASCENDING
    public static List<Course> selectQueryCourse(String criteria){        
        List<Course> result = new ArrayList<>();
        String sql = "SELECT * FROM course WHERE nama LIKE '%" + criteria + "%' OR courseID LIKE '" + criteria + "%' OR teacher LIKE '%" + criteria + "%' ORDER BY poinDapat ASC";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("courseID"));
                c.setLanguage(rs.getString("language"));
                c.setNama(rs.getString("nama"));
                c.setPoinMinimum(rs.getInt("minimumPoin"));
                c.setPoinDapat(rs.getInt("poinDapat"));
                c.setTeacher(rs.getString("teacher"));
                result.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    //SELECT COURSE BERDASARKAN CRITERIA DARI SEARCH FIELD, NAMUN DENGAN TAMBAHAN DAPAT SORTING BERDASARKAN COLUMN HEADER TABEL 
    public static List<Course> selectQueryCourse(String criteria, String filter){        
        List<Course> result = new ArrayList<>();
        String sql = "SELECT * FROM course WHERE nama LIKE '%" + criteria + "%' OR courseID LIKE '" + criteria + "%' OR teacher LIKE '%" + criteria + "%' ORDER BY " + filter + " ASC";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("courseID"));
                c.setLanguage(rs.getString("language"));
                c.setNama(rs.getString("nama"));
                c.setPoinMinimum(rs.getInt("minimumPoin"));
                c.setPoinDapat(rs.getInt("poinDapat"));
                c.setTeacher(rs.getString("teacher"));
                result.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    //SAMA SEPERTI QUERY DI ATAS, NAMUN DAPAT MELAKUKAN SORTING SECARA ASCENDING ATAU DESCENDING, TERDAPAT PADA TABEL HOMEWINDOW DENGAN MENGKLIK COLUMN HEADER
    public static List<Course> selectQueryCourse(String criteria, String filter, String order){        
        List<Course> result = new ArrayList<>();
        String sql = "SELECT * FROM course WHERE nama LIKE '%" + criteria + "%' OR courseID LIKE '" + criteria + "%' OR teacher LIKE '%" + criteria + "%' OR language LIKE '%" + criteria + "%' ORDER BY " + filter + " " + order;
        System.out.println(sql);
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("courseID"));
                c.setLanguage(rs.getString("language"));
                c.setNama(rs.getString("nama"));
                c.setPoinMinimum(rs.getInt("minimumPoin"));
                c.setPoinDapat(rs.getInt("poinDapat"));
                c.setTeacher(rs.getString("teacher"));
                result.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    //SAMA SEPERTI QUERY DI ATAS, NAMUN DAPAT MELAKUKAN SORTING SECARA ASCENDING ATAU DESCENDING, TERDAPAT PADA TABEL HOMEWINDOW DENGAN MENGKLIK COLUMN HEADER
    public static List<Course> selectQueryCourse(String filter, String order, int boundaryPoinDapat, int boundaryMinimumPoin){        
        List<Course> result = new ArrayList<>();
        String sql = "SELECT * FROM course WHERE poinDapat >= " + boundaryPoinDapat + " AND minimumPoin >= " + boundaryMinimumPoin + " ORDER BY " + filter + " " + order;
        System.out.println(sql);
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("courseID"));
                c.setLanguage(rs.getString("language"));
                c.setNama(rs.getString("nama"));
                c.setPoinMinimum(rs.getInt("minimumPoin"));
                c.setPoinDapat(rs.getInt("poinDapat"));
                c.setTeacher(rs.getString("teacher"));
                result.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    //SELECT HANYA SATU COURSE BERDASARKAN ID COURSE NYA, KEMBALIAN BERUPA OBJECT COURSE TUNGGAL
    public static Course selectQueryCourseSingular(String id){        
        Course result = new Course();
        String sql = "SELECT * FROM course WHERE courseID = '" + id + "'";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                result.setId(rs.getString("courseID"));
                result.setLanguage(rs.getString("language"));
                result.setNama(rs.getString("nama"));
                result.setPoinMinimum(rs.getInt("minimumPoin"));
                result.setPoinDapat(rs.getInt("poinDapat"));
                result.setTeacher(rs.getString("teacher"));
            }
        } catch (SQLException e) {
            System.out.println("CourseDatabaseClass "+e.getMessage());
        }
        return result;
    }
    
    //QUERY UNTUK MELAKUKAN INSERT COURSE, MENGGUNAKAN PARAMETER-PARAMETER DARI TEXT FIELD YANG ADA PADA TAMBAHCOURSEWINDOW
    public static void insertQueryCourse(String id, String nama, int poinMin, int poinDapat, String user) {
        String sql = "INSERT INTO course(courseID,language,nama,minimumPoin,poinDapat,teacher) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DatabaseClass.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, CourseLogicClass.bahasaProgram(id));
            pstmt.setString(3, nama);
            pstmt.setInt(4, poinMin);
            pstmt.setInt(5, poinDapat);
            pstmt.setString(6, user);
            pstmt.executeUpdate();
            System.out.println("Course created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //MELAKUKAN EDIT DATA COURSE, YANG DIEDTI HANYALAH NAMA, POIN YANG DIDAPATKAN, DAN POIN MINIMUM SAJA
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
    
    //MELAKUKAN DELETE COURSE BERDASARKAN COURSE ID YANG DIPILIH DARI TABEL
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
