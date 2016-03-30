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
public class haversineFormula {

    public static double R = 6371000; // In metres

    public haversineFormula() {
    }

    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        // System.out.println("dLat " +dLat);  
        //   System.out.println("dLon " +dLon); 
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        // System.out.println("Lat 1: " + lat1);
        // System.out.println("Lat 2: " + lat2);
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
        //  System.out.println("A: " + a);
        double c = 2 * Math.asin(Math.sqrt(a));
        //  System.out.println("C: "+ c);
        return  R * c;

    }
//    static Double degToRad = Math.PI / 180.0;


    public static void main(String[] args) {

        System.out.println(haversine(53.616262, -6.188280,53.616617, -6.187876));
        System.out.println(haversine(53.616262, -6.188280, 53.616758, -6.188260));
    }
}
