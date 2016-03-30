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
public class findAngle {

    public findAngle() {
    
    }

    

    /**
     * @param args the command line arguments
     */
    public static double getAngle(double lat1, double long1, double lat2, double long2) {

        double xDiff = long2 - long1;
        double yDiff = lat2 - lat1;
        return (Math.atan2(yDiff, xDiff) * (180 / Math.PI));

    }

    public static void main(String[] args) {
        double degreeError = getAngle(53.616262, -6.188280, 53.616411, -6.187576);
        System.out.println("Degree error: " + degreeError);
       // System.out.println("From Bottom pitch to top: " + getAngle(53.616262, -6.188280, 53.617005, -6.189024));
       // System.out.println("Perspective angle: " + (getAngle(53.616262, -6.188280, 53.617022, -6.188659) - degreeError));
       // System.out.println("Perspective angle: " + (getAngle(53.616262, -6.188280, 53.616617, -6.187876) - degreeError));
       // System.out.println("Perspective angle: " + (getAngle(53.616262, -6.188280, 53.616758, -6.188260) - degreeError));
    }

}
