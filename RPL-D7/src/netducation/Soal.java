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
public class Soal {
    private String courseID;
    private String soal;
    private String jawabanBenar;
    private int poin;
    
    /**
     * @return the courseID
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * @param courseID the courseID to set
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    /**
     * @return the soal
     */
    public String getSoal() {
        return soal;
    }

    /**
     * @param soal the soal to set
     */
    public void setSoal(String soal) {
        this.soal = soal;
    }

    /**
     * @return the jawabanBenar
     */
    public String getJawabanBenar() {
        return jawabanBenar;
    }

    /**
     * @param jawabanBenar the jawabanBenar to set
     */
    public void setJawabanBenar(String jawabanBenar) {
        this.jawabanBenar = jawabanBenar;
    }

    /**
     * @return the poin
     */
    public int getPoin() {
        return poin;
    }

    /**
     * @param poin the poin to set
     */
    public void setPoin(int poin) {
        this.poin = poin;
    }    
}
