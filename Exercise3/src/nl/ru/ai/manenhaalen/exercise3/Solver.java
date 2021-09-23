//Cody van Haalen s1075021
// Pepijn van Manen s484004
package nl.ru.ai.manenhaalen.exercise3;

import java.util.Scanner;

public class Solver
{
    public static void main(String[] args)
    {
        double inputA, inputB, inputC;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Quadratic Formula Solver");
        System.out.println("Quadratic Formulas are in the format ax^2 + bx + c");
        System.out.println("Please enter the 'a' number of the quadratic formula ");
        do
        {
            System.out.println("'a' can not be zero.");
            inputA = input.nextDouble();
        }
        while(inputA == 0);
        System.out.println("Please enter the 'b' number of the quadratic formula ");
        inputB = input.nextDouble();
        System.out.println("Please enter the 'c' number of the quadratic formula ");
        inputC = input.nextDouble();
        solve (inputA, inputB, inputC);
    }

    public static void solve(double a, double b, double c)
    {
        double d = (b * b) - (4 * a * c);
        if (d < 0)
        {
            System.out.println("No (real) solution found");
        }
        else if (d == 0)
        {
            double x = -b / (2 * a);
            System.out.println("There is 1 solution: " + x);
        }
        else
        {
            d = Math.sqrt(d);
            double x1 = (-b + d) / (2 * a);
            double x2 = (-b - d) / (2 * a);
            System.out.println("There are 2 solutions: " + x1 + " and " + x2);
        }
    }
}
