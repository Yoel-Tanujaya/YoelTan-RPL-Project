/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netducation;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yoelt
 */
public class RelationalLogicClass {
    public static void takeCourse(Users u, Course c) {
        HomeWindow hw = new HomeWindow();
        System.out.println(u.getUsername() + " " + RelationalDatabaseClass.selectCourseTakenSingular(u.getUsername(),c.getId()));
        if (RelationalDatabaseClass.selectCourseTakenSingular(u.getUsername(),c.getId()).isEmpty()) {
            System.out.println(RelationalDatabaseClass.selectCourseTakenSingular(u.getUsername(),c.getId()));
            RelationalDatabaseClass.insertCourseTaken(u.getUsername(), c.getId());
            DatabaseClass.updatePoint(u.getUsername(), c.getPoinDapat());
            System.out.println(u.getUsername() + " " + c.getId());
            JOptionPane.showMessageDialog(hw, "Course berhasil diambil", "Course Completed", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(hw, "Course Already Taken", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void filtering() {
        
    }
    
    public static  void rateCourse(String courseID, String user, int rating) {
        HomeWindow hw = new HomeWindow();
        if (RelationalDatabaseClass.selectRatingByCourseSingular(courseID, user).isEmpty()) {
            if (RelationalDatabaseClass.selectCourseTakenSingular(user,courseID).isEmpty()) {
                
            }
            else {
                RelationalDatabaseClass.insertRatingCourseByUser(courseID, user, rating);
                JOptionPane.showMessageDialog(hw, "Rate has been added for this course. Thank You :)", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
            System.out.println("ERROR RATING COURSE DOUBLE ");
        }
    }
    
    public static  void rateAdmin(String admin, String user, String courseID, int rating) {
        HomeWindow hw = new HomeWindow();
        if (RelationalDatabaseClass.selectRatingByAdminSingular(admin, user).isEmpty()) {
            if (RelationalDatabaseClass.selectCourseTakenSingular(user,courseID).isEmpty()) {
                
            }
            else {
                RelationalDatabaseClass.insertRatingAdminByUser(admin, user, rating);
                JOptionPane.showMessageDialog(hw, "Rate has been added for this admin. Thank You :)", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
            System.out.println("ERROR RATING ADMIN DOUBLE");
        }
    }
    
    public static Boolean checkRatingCourseValidation(String user, String courseID) {
        Boolean r;
        if (RelationalDatabaseClass.selectCourseTakenSingular(user,courseID).isEmpty()) {
            r=false;
        }
        else {
            if (RelationalDatabaseClass.selectRatingByCourseSingular(courseID, user).isEmpty()) {
                r=true;
            }
            else r=false;
        }
        return r;
    }
    
    public static Boolean checkRatingAdminValidation(String user, String admin, String courseID) {
        Boolean r;
        if (RelationalDatabaseClass.selectCourseTakenSingular(user,courseID).isEmpty()) {
            r=false;
        }
        else {
            if (RelationalDatabaseClass.selectRatingByAdminSingular(admin, user).isEmpty()) {
                r=true;
            }
            else r=false;
        }
        return r;
    }
    
    public static DefaultTableModel showCourseTakenByUsername(Users u) {
        DefaultTableModel tm = new DefaultTableModel(new Object [][] {
    },
    new String [] {
        "ID Course", "Nama Course", "Poin Didapat", "Pengajar", "Rating yang diberi"
    });
        for (Course c : RelationalDatabaseClass.selectCourseTakenList(u.getUsername())) {
            Object o = new Object[]{c.getId(),c.getNama(),c.getPoinDapat(),c.getTeacher(),RelationalDatabaseClass.selectRatingUser(u.getUsername(), c.getId())};
            tm.addRow((Object[]) o);
            System.out.println(c.getId() + " " + c.getNama() + " " + c.getPoinDapat() + " " + c);
        }
        return tm;
    }
    
}
