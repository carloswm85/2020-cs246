package CircleCalculator;

import java.util.Scanner;

import static java.lang.Math.PI;

public class CircleCalculator {

    private static final Scanner _scanner = new Scanner( System.in );

    private double getRadius() {
        double radius;
        // double radius = _scanner.nextDouble();
        String number = _scanner.nextLine();
        radius = Double.parseDouble(number);
        return radius;
    }

    private void displayCircumference(double radius) {
        double circumference = 2 * PI * radius;
        System.out.format("%.2f%n", circumference);
    }

    private void displayArea(double radius) {
        double area = PI * radius * radius;
        System.out.format("%.2f%n", area);
    }

    public static void main(String[] args) {
        CircleCalculator calculator =  new CircleCalculator();
        double radius = calculator.getRadius();
        calculator.displayCircumference(radius);
        calculator.displayArea(radius);
    }
}
