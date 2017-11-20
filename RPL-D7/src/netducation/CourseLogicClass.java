/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netducation;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yoelt
 */
public class CourseLogicClass {
    public static String bahasaProgram(String id) {
        String ret = "";
        if (id.startsWith("CPL")) {
            ret = "C Programming Language";
        }
        else if (id.startsWith("CPP")) {
            ret = "C++ Programming Language";
        }
        else if (id.startsWith("OOP")) {
            ret = "Java";
        }
        else if (id.startsWith("IOS")) {
            ret = "Apple Swift 3";
        }
        else if (id.startsWith("AND")) {
            ret = "Kotlin Beta for Android";
        }
        else if (id.startsWith("PHY")) {
            ret = "Phyton Language";
        }
        else {
            ret = "Other Language";
        }
        return ret;
    }
    
    public static int avgRate(String cID) {
        return RelationalDatabaseClass.courseAverageRating(cID);
    }
    
    public static int insertCourseValidation(String id, String nama, int poinMin, int poinDapat, Users u) {
        List<Course> lc = CourseDatabaseClass.selectQueryCourse();
        int res = 0;
        Boolean validity = true;
        for (Course c : lc) {
            if (c.getId().equalsIgnoreCase(id)) {
                res = 1; //id sama
                validity = false;
            }
            if (c.getNama().equalsIgnoreCase(nama)) {
                res = 2; // nama sama
                validity = false;
            }
        }
        if (validity == true) {
            CourseDatabaseClass.insertQueryCourse(id, nama, poinMin, poinDapat, u.getUsername());
            System.out.println("Course Created");
        }
        return res;
    }
    
    public static int editCourseValidation(String id, String nama, int poinMin, int poinDapat) {
        List<Course> lc = CourseDatabaseClass.selectQueryCourse();
        int res = 0;
        Boolean validity = true;
        for (Course c : lc) {
            if (c.getNama().equalsIgnoreCase(nama)) {
                res = 2;
                validity = false;
            }
        }
        if (validity == true) {
            CourseDatabaseClass.updateQueryCourse(id, nama, poinMin, poinDapat);
            System.out.println("Course Edited");
        }
        return res;
    }
    
    public static void deleteCourse(String id) {
        CourseDatabaseClass.deleteQueryCourse(id);
        System.out.println("DELETE SUCCESS");
    }
    
    public static DefaultTableModel searchCourse(Users u, String criteria) {
        DefaultTableModel tm = new DefaultTableModel(new Object [][] {

    },
    new String [] {
        "ID Course", "Nama Course", "Bahasa Program", "Poin Minimum", "Poin Didapat", "Pengajar", "Rating"
    });
        for (Course c : CourseDatabaseClass.selectQueryCourse(criteria)) {
            if (u.getRole() == 1) tm.addRow(new Object[]{c.getId(),c.getNama(),bahasaProgram(c.getId()),c.getPoinMinimum(),c.getPoinDapat(),c.getTeacher(),avgRate(c.getId())});
            else if (c.getPoinMinimum() <= u.getPoint() && u.getRole() == 2) tm.addRow(new Object[]{c.getId(),c.getNama(),bahasaProgram(c.getId()),c.getPoinMinimum(),c.getPoinDapat(),c.getTeacher(),avgRate(c.getId())});
            System.out.println(c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + avgRate(c.getId()));
        }
        return tm;
    }
    
    public static DefaultTableModel showAllCourseData() {
        int i=1;
        DefaultTableModel tm = new DefaultTableModel(new Object [][] {
    },
    new String [] {
        "ID Course", "Nama Course", "Bahasa Program", "Poin Minimum", "Poin Didapat", "Pengajar", "Rating"
    });
        for (Course c : CourseDatabaseClass.selectQueryCourse()) {
            
            Object o = new Object[]{c.getId(),c.getNama(),bahasaProgram(c.getId()),c.getPoinMinimum(),c.getPoinDapat(),c.getTeacher(),avgRate(c.getId()),avgRate(c.getId())};
            tm.addRow((Object[]) o);
            System.out.println(i++ + " " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
        }
        tm.fireTableDataChanged();
        return tm;
    }
    
    public static DefaultTableModel showAllCourseData(Users u) {
        int i=1;
        DefaultTableModel tm = new DefaultTableModel(new Object [][] {
    },
    new String [] {
        "ID Course", "Nama Course", "Bahasa Program", "Poin Minimum", "Poin Didapat", "Pengajar", "Rating"
    });
        if (u.getRole() == 1) {
            for (Course c : CourseDatabaseClass.selectQueryCourse()) {
                Object o = new Object[]{c.getId(),c.getNama(),bahasaProgram(c.getId()),c.getPoinMinimum(),c.getPoinDapat(),c.getTeacher(),avgRate(c.getId())};
                tm.addRow((Object[]) o);
                System.out.println(i++ + " " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
            }
        }
        else if (u.getRole() == 2) {
            for (Course c : CourseDatabaseClass.selectQueryCourse()) {
                if (u.getPoint() >= c.getPoinMinimum()) {
                    Object o = new Object[]{c.getId(),c.getNama(),bahasaProgram(c.getId()),c.getPoinMinimum(),c.getPoinDapat(),c.getTeacher(),avgRate(c.getId())};
                    tm.addRow((Object[]) o);
                    System.out.println(i++ + " " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
                }
            }
        }
        
        return tm;
    }
    
    public static DefaultTableModel sortTableCourse(Users u, String criteria, String header, String order) {
        int i=1;
        DefaultTableModel tm = new DefaultTableModel(new Object [][] {
    },
    new String [] {
        "ID Course", "Nama Course", "Bahasa Program", "Poin Minimum", "Poin Didapat", "Pengajar", "Rating"
    });
        if (u.getRole() == 1) {
            for (Course c : CourseDatabaseClass.selectQueryCourse(criteria, header, order)) {
                Object o = new Object[]{c.getId(),c.getNama(),bahasaProgram(c.getId()),c.getPoinMinimum(),c.getPoinDapat(),c.getTeacher(),avgRate(c.getId())};
                tm.addRow((Object[]) o);
                System.out.println(i++ + " " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
            }
        }
        else if (u.getRole() == 2) {
            for (Course c : CourseDatabaseClass.selectQueryCourse(criteria, header, order)) {
                if (u.getPoint() >= c.getPoinMinimum()) {
                    Object o = new Object[]{c.getId(),c.getNama(),bahasaProgram(c.getId()),c.getPoinMinimum(),c.getPoinDapat(),c.getTeacher(),avgRate(c.getId())};
                    tm.addRow((Object[]) o);
                    System.out.println(i++ + " " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
                }
            }
        }
        tm.fireTableDataChanged();
        return tm;
    }
    
    public static DefaultTableModel sortTableCourse(Users u, String header, String order, int batasPoinDapat, int batasMinPoin) {
        int i=1;
        DefaultTableModel tm = new DefaultTableModel(new Object [][] {
    },
    new String [] {
        "ID Course", "Nama Course", "Bahasa Program", "Poin Minimum", "Poin Didapat", "Pengajar", "Rating"
    });
        if (u.getRole() == 1) {
            for (Course c : CourseDatabaseClass.selectQueryCourse(header, order, batasPoinDapat, batasMinPoin)) {
                Object o = new Object[]{c.getId(),c.getNama(),bahasaProgram(c.getId()),c.getPoinMinimum(),c.getPoinDapat(),c.getTeacher(),avgRate(c.getId())};
                tm.addRow((Object[]) o);
                System.out.println(i++ + " " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
            }
        }
        else if (u.getRole() == 2) {
            for (Course c : CourseDatabaseClass.selectQueryCourse(header, order, batasPoinDapat, batasMinPoin)) {
                if (u.getPoint() >= c.getPoinMinimum()) {
                    Object o = new Object[]{c.getId(),c.getNama(),bahasaProgram(c.getId()),c.getPoinMinimum(),c.getPoinDapat(),c.getTeacher(),avgRate(c.getId())};
                    tm.addRow((Object[]) o);
                    System.out.println(i++ + " " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
                }
            }
        }
        tm.fireTableDataChanged();
        return tm;
    }
    
    public static DefaultTableModel showAllCourseDataByRating(Users u, int rate) {
        int i=1;
        DefaultTableModel tm = new DefaultTableModel(new Object [][] {
    },
    new String [] {
        "ID Course", "Nama Course", "Bahasa Program", "Poin Minimum", "Poin Didapat", "Pengajar", "Rating"
    });
        if (u.getRole() == 1) {
            for (Course c : RelationalDatabaseClass.selectCourseByRating(rate)) {
                Object o = new Object[]{c.getId(),c.getNama(),bahasaProgram(c.getId()),c.getPoinMinimum(),c.getPoinDapat(),c.getTeacher(),avgRate(c.getId())};
                tm.addRow((Object[]) o);
                System.out.println(i++ + " " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
            }
        }
        else if (u.getRole() == 2) {
            for (Course c : RelationalDatabaseClass.selectCourseByRating(rate)) {
                if (u.getPoint() >= c.getPoinMinimum()) {
                    Object o = new Object[]{c.getId(),c.getNama(),bahasaProgram(c.getId()),c.getPoinMinimum(),c.getPoinDapat(),c.getTeacher(),avgRate(c.getId())};
                    tm.addRow((Object[]) o);
                    System.out.println(i++ + " " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
                }
            }
        }
        return tm;
    }
    
    public static DefaultTableModel sortTableCourseByRating(Users u, int rate, String criteria, String header, String order) {
        int i=1;
        DefaultTableModel tm = new DefaultTableModel(new Object [][] {
    },
    new String [] {
        "ID Course", "Nama Course", "Bahasa Program", "Poin Minimum", "Poin Didapat", "Pengajar", "Rating"
    });
        if (u.getRole() == 1) {
            for (Course c : CourseDatabaseClass.selectQueryCourse(criteria, header, order)) {
                if (avgRate(c.getId())==rate) {
                    Object o = new Object[]{c.getId(),c.getNama(),bahasaProgram(c.getId()),c.getPoinMinimum(),c.getPoinDapat(),c.getTeacher(),avgRate(c.getId())};
                    tm.addRow((Object[]) o);
                    System.out.println(i++ + " " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
                }
                else if (avgRate(c.getId())==0) {
                    Object o = new Object[]{c.getId(),c.getNama(),bahasaProgram(c.getId()),c.getPoinMinimum(),c.getPoinDapat(),c.getTeacher(),avgRate(c.getId())};
                    tm.addRow((Object[]) o);
                    System.out.println(i++ + " " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
                }
            }
        }
        else if (u.getRole() == 2) {
            for (Course c : CourseDatabaseClass.selectQueryCourse(criteria, header, order)) {
                if (u.getPoint() >= c.getPoinMinimum()) {
                    if (avgRate(c.getId())==rate) {
                        Object o = new Object[]{c.getId(),c.getNama(),bahasaProgram(c.getId()),c.getPoinMinimum(),c.getPoinDapat(),c.getTeacher(),avgRate(c.getId())};
                        tm.addRow((Object[]) o);
                        System.out.println(i++ + " " + c.getId() + " " + c.getNama() + " " + c.getPoinMinimum() + " " + c.getPoinDapat() + " " + c);
                    }
                }
            }
        }
        return tm;
    }
    
    
}
