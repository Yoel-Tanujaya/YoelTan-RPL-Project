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

public class RelationalDatabaseClass {    
    
    //----------------- MENAMPILKAN DAFTAR COURSE APA SAJA YANG SUDAH DIAMBIL OLEH USER (PARAMETER), MENGGUNAKAN DB COURSE, COURSE_TAKEN, DAN USERS, DITAMPILKAN BERUPA TABEL--------------
    public static List<Course> selectCourseTakenList(String user){ 
        List<Course> r = new ArrayList<>();
        String sql = "SELECT c.courseID, c.nama, c.minimumPoin, c.poinDapat, c.teacher FROM course AS c INNER JOIN course_taken AS ct ON c.courseID=ct.courseID WHERE ct.username='" + user + "'";
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
                c.setTeacher(rs.getString("teacher"));
                r.add(c);
                //System.out.println("PRINTED FROM RELATIONAL DB CLASS " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }
    
    //----------------- MENAMPILKAN APAKAH COURSEID(PARAMETER) SUDAH DIAMBIL OLEH USER(PARAMETER), MENGGUNAKAN DB COURSE_TAKEN, DITAMPILKAN BERUPA SATU OBJECT COURSE, JIKA TIDAK ADA MAKA AKAN RETURN NULL/EMPTY--------------
    public static String selectCourseTakenSingular(String user, String course){       
        String res="";
        String sql = "SELECT courseID, username FROM course_taken WHERE username='" + user + "' AND courseID='" + course + "'";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                System.out.println(rs.getString("courseID"));
                res = rs.getString("courseID");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
    
    //----------------- MENAMPILKAN DAFTAR COURSE APA SAJA YANG BERNILAI SEBESAR RATING (PARAMETER) MENGGUNAKAN DB COURSE, RATING_COURSE, DITAMPILKAN BERUPA TABEL--------------
    public static List<Course> selectCourseByRating(int rating){
        List<Course> r = new ArrayList<>();
        String sql = "SELECT rc.courseID, c.nama, c.minimumPoin, c.poinDapat FROM course AS c, rating_course AS rc WHERE rc.rating=" + rating + " AND rc.courseID=c.courseID";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("rc.courseID"));
                c.setNama(rs.getString("c.nama"));
                c.setPoinMinimum(rs.getInt("c.minimumPoin"));
                c.setPoinDapat(rs.getInt("c.poinDapat"));
                r.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }
    
    //--------------- MENAMPILKAN DAFTAR COURSE APA SAJA YANG YANG BERNILAI SEBESAR RATING (PARAMETER) DENGAN MENGGUNAKAN FUNGSI SEARCH (PARAMETER CRITERIA ----------------------------
    //------ SEARCH FILTER BERDASARKAN KOLOM POIN / ID / NAMA / POINMIN, DAN URUTAN TAMPILAN (ASC/DESC), MENGGUNAKAN DB RATING_COURSE DAN COURSE, DITAMPILKAN BERUPA TABEL--------------
    public static List<Course> selectCourseByRating(int rating, String criteria, String filter, String order){
        List<Course> r = new ArrayList<>();
        String sql = "SELECT c.courseID, c.nama, c.minimumPoin, c.poinDapat FROM course AS c INNER JOIN rating_course AS rc ON c.courseID=rc.courseID WHERE rc.rating=" + rating + " AND c.nama LIKE '%" + criteria + "%' OR rc.courseID LIKE '%" + criteria + "%' ORDER BY rc.courseID " + order;
        System.out.println(sql);
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("c.courseID"));
                c.setLanguage(rs.getString("language"));
                c.setNama(rs.getString("c.nama"));
                c.setPoinMinimum(rs.getInt("c.minimumPoin"));
                c.setPoinDapat(rs.getInt("c.poinDapat"));
                c.setTeacher(rs.getString("teacher"));
                r.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }
    
    public static List<Course> selectAdminByCourse(String user){ 
        List<Course> r = new ArrayList<>();
        String sql = "SELECT ct.courseID, c.nama, c.minimumPoin, c.poinDapat, u.username FROM course AS c, users AS u, course_taken AS ct WHERE ct.username='" + user + "' AND ct.courseID=c.courseID";
        //String sql = "SELECT course_taken.courseID, course_taken.username FROM course_taken UNION SELECT * FROM course UNION SELECT users.username FROM users WHERE course_taken.courseID=course.courseID AND course_taken.username='" + user + "'";
        System.out.println(sql);
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("c.courseID"));
                c.setNama(rs.getString("c.nama"));
                c.setPoinMinimum(rs.getInt("c.minimumPoin"));
                c.setPoinDapat(rs.getInt("c.poinDapat"));
                r.add(c);
                //System.out.println("PRINTED FROM RELATIONAL DB CLASS " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }
    
    public static List<Rating> selectRatingByCourse(String courseID){ //menampilkan penilaian / rating sebuah course yang diberikan oleh user, kembalian data berupa list rating, parameter beupa course yang dipilih saat itu       
        List<Rating> lr = new ArrayList<>();
        String sql = "SELECT rc.courseID, rc.rating, c.nama, u.username FROM course AS c, rating_course AS rc, users u WHERE rc.courseID='" + courseID + "'";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Rating r = new Rating();
                r.setCourse(rs.getString("c.nama"));
                r.setUsername(rs.getString("u.username"));
                r.setRating(rs.getInt("rc.rating"));
                lr.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lr;
    }
    
    public static String selectRatingByCourseSingular(String courseID, String user){
        String res="";
        String sql = "SELECT rc.courseID, rc.rating, c.nama, u.username FROM course AS c, rating_course AS rc, users AS u WHERE rc.courseID='" + courseID + "' AND u.username='" + user + "'";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                res = rs.getString("rc.rating");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
    
    //MENAMPILKAN NILAI RATA2 RATING YANG DITERIMA OLEH COURSE TERSEBUT, DARI RATING COURSE AKAN DIAMBIL NILAI RATINGNYA, LALU DI AVERAGE MENJADI SEBUAH NILAI
    public static int courseAverageRating(String courseID) {
        int avg = 0;
        String sql = "SELECT AVG(rating) FROM rating_course WHERE courseID='" + courseID + "'";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                avg=rs.getInt("AVG(rating)");
                System.out.println(avg);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return avg;
    }
    
    public static String adminAverageRating(String admin) {
        String avg = "";
        String sql = "SELECT AVG(rating) FROM rating_admin WHERE usernameAdmin='" + admin + "'";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                avg=rs.getString("AVG(rating)");
                System.out.println(avg);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return avg;
    }
    
    public static int selectRatingUser(String user, String courseID) {
        int x=0;
        String sql = "SELECT rating FROM rating_course WHERE courseID='" + courseID + "' AND username='" + user + "'";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                x=rs.getInt("rating");
                System.out.println(x);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return x;
    }
    
    public static List<Rating> selectRatingByAdmin(String user){ //Menampilkan penilaian / rating dari seorang user admin yang diberikan oleh user lainnya, lembalian data berupa list rating, parameter berupa user yang sedang login ssat melihat laporan       
        List<Rating> lr = new ArrayList<>();
        String sql = "SELECT usernameRater, rating FROM rating_admin WHERE usernameAdmin='" + user + "'";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Rating r = new Rating();
                r.setUsername(rs.getString("usernameRater"));
                r.setRating(rs.getInt("rating"));
                lr.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lr;
    }
    
    public static String selectRatingByAdminSingular(String admin, String user){ 
        String res="";
        String sql = "SELECT usernameRater, usernameAdmin FROM rating_admin WHERE usernameAdmin='" + admin + "' AND usernameRater='" + user + "'";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                res = rs.getString("rating");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
    
    public static List<Course> selectCourseByAdmin(String admin, String header, String order) {
        List<Course> r = new ArrayList<>();
        String sql = "SELECT courseID, nama FROM course WHERE teacher='" + admin + "' ORDER BY " + header + " " + order + "";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("courseID"));
                c.setNama(rs.getString("nama"));
                r.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }
    
    public static List<Course> selectCourseByAdmin(String admin) {
        List<Course> r = new ArrayList<>();
        String sql = "SELECT courseID, nama FROM course WHERE teacher='" + admin + "'";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString("courseID"));
                c.setNama(rs.getString("nama"));
                r.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }
    
    public static int countUserTakeCourse(String courseID) {
        int x=0;
        String sql = "SELECT COUNT(username) FROM course_taken WHERE courseID='" + courseID + "'";
        try (Connection conn = DatabaseClass.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                x = rs.getInt("COUNT(username)");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return x;
    }
    
    public static void insertCourseTaken(String user, String courseID){        
        String sql = "INSERT INTO course_taken(courseID,username) VALUES(?,?)";
        try (Connection conn = DatabaseClass.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseID);
            pstmt.setString(2, user);
            pstmt.executeUpdate();
            System.out.println("Course Taken");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void insertRatingCourseByUser(String courseID, String username, int rating) {
        String sql = "INSERT INTO rating_course(courseID,username,rating) VALUES(?,?,?)";
        try (Connection conn = DatabaseClass.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseID);
            pstmt.setString(2, username);
            pstmt.setInt(3, rating);
            pstmt.executeUpdate();
            System.out.println("Rating sdded for this course");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void insertRatingAdminByUser(String adminUser, String user, int rating) {
        String sql = "INSERT INTO rating_admin(usernameAdmin,usernameRater,rating) VALUES(?,?,?)";
        try (Connection conn = DatabaseClass.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, adminUser);
            pstmt.setString(2, user);
            pstmt.setInt(3, rating);
            pstmt.executeUpdate();
            System.out.println("Rating added for this admin");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
