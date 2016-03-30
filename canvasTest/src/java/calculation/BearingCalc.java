/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculation;

/**
 *
 * @author Lenovo
 */
public class BearingCalc {

    //static Double degToRad = Math.PI / 180.0;
    public static double bearingDegrees(double lat1, double long1, double lat2, double long2) {
        double longitude1 = long1;
        double longitude2 = long2;
        double latitude1 = Math.toRadians(lat1);
        //System.out.println(latitude1);
        double latitude2 = Math.toRadians(lat2);
        double longDiff = Math.toRadians(longitude2 - longitude1);
        double y = Math.sin(longDiff) * Math.cos(latitude2);

        double x = Math.cos(latitude1) * Math.sin(latitude2) - Math.sin(latitude1) * Math.cos(latitude2) * Math.cos(longDiff);
        //System.out.println("Y: "+y);
        //System.out.println("X: "+x);
        // System.out.println(Math.atan2(y, x));
        //System.out.println(Math.toDegrees(Math.atan2(y, x)) + 360);
        return (Math.toDegrees(Math.atan2(y, x)) + 360) % 360;

    }

    public static void main(String[] args) {

        System.out.println(bearingDegrees(53.616262, -6.188280, 53.61673167, -6.18797167) + " bearing in degrees");
    }
}
