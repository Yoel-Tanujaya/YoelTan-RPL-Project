package netducation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoelt
 */
public class Course {
    private String nama;
    private String id;
    private String image;
    private int poinMinimum;
    private int poinDapat;
    
    Course() {
        
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the poinMinimum
     */
    public int getPoinMinimum() {
        return poinMinimum;
    }

    /**
     * @param poinMinimum the poinMinimum to set
     */
    public void setPoinMinimum(int poinMinimum) {
        this.poinMinimum = poinMinimum;
    }

    /**
     * @return the poinDapat
     */
    public int getPoinDapat() {
        return poinDapat;
    }

    /**
     * @param poinDapat the poinDapat to set
     */
    public void setPoinDapat(int poinDapat) {
        this.poinDapat = poinDapat;
    }
    
    
}
