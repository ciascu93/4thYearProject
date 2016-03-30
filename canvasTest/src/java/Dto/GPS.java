/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

/**
 *
 * @author Lenovo
 */
public class GPS {

    private double latitude;
    private double longitude;

    public GPS() {
    }

    public GPS(double latitude, double longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
   public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

 

}
