//Cody van Haalen s1075021
// Pepijn van Manen s484004
package nl.ru.ai.manenhaalen.exercise3;

import java.util.Scanner;

public class NewtonRaphson
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        double inputNumber, root, formula, derivate, approximate;
        root = 1;

        System.out.println("This tool will approximate the root of a number using the Newton-Raphson formula.");
        do
        {
            System.out.println("Please enter any number above zero.");
            inputNumber = input.nextDouble();
        }
        while (inputNumber <= 0);

        do
        {
            formula = (root * root) - inputNumber;
            derivate = (2 * root);
            approximate = (formula / derivate);
            root = root - approximate;
        }
        while (Math.abs(approximate) > 0.001);
        System.out.println("The approximate root of " +inputNumber +" is " +root +".");
    }
}
