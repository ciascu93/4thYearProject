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
public class findCoords {

    public static double findX(double angle, double hyp) {

        double x = (Math.cos(Math.toRadians(angle)) * hyp);

        return x;
    }

    public static double findY(double angle, double hyp) {

        double y = (Math.sin(Math.toRadians(angle)) * hyp);

        return y;
    }

    public static void main(String[] args) {

        System.out.println("Find X: "+ (findX(76.09,88)*5) + " Find Y: " + (findY(76.09,88)*5));
        System.out.println("Find X: "+ (findX(21.47,47.63)*5) + " Find Y: " + (findY(21.47,47.63)*5));
        System.out.println("Find X: "+ (findX(55.41,55.16)*5) + " Find Y: " + (findY(55.41,55.16)*5));
    }
}
