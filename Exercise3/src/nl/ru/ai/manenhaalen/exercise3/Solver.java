package nl.ru.ai.manenhaalen.exercise3;

import java.util.Scanner;

public class Solver {
    public static void main(String[] args){
        solve(2, 0, -4);
        double inputA, inputB, inputC;
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter three input numbers: ");
        inputA = input.nextDouble();
        inputB = input.nextDouble();
        inputC = input.nextDouble();
        if (inputA == 0)
            System.out.println("This input is not correct.");
        solve (inputA, inputB, inputC);
    }

    public static void solve(double a, double b, double c){
        double d = (b * b) - (4 * a * c);
        if (d < 0) System.out.println("No (real) solution found");
        else if (d == 0){
            double x = -b / (2 * a);
            System.out.println("There is 1 solution: " + x);
        }
        else{
            d = Math.sqrt(d);
            double x1 = (-b + d) / (2 * a);
            double x2 = (-b - d) / (2 * a);
            System.out.println("There are 2 solutions: " + x1 + " and " + x2);
        }
    }
}
