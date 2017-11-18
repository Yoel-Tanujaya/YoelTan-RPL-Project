/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netducation;

/**
 *
 * @author yoelt
 */
public class Rating {
    private int rating;
    private String course;
    private String username;
    private String userAdmin;
    
    Rating(String course, String user, int rating) {
        this.course = course;
        this.username = user;
        this.rating = rating;
    }
    
    Rating(int rating, String user, String admin) {
        this.username = user;
        this.userAdmin = admin;
        this.rating = rating;
    }

    Rating() {
        
    }
    
    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return the courseID
     */
    public String getCourse() {
        return course;
    }

    /**
     * @param courseID the courseID to set
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    
    /**
     * @return the userAdmin
     */
    public String getUserAdmin() {
        return userAdmin;
    }

    /**
     * @param userAdmin the userAdmin to set
     */
    public void setUserAdmin(String userAdmin) {
        this.userAdmin = userAdmin;
    }
    
}
