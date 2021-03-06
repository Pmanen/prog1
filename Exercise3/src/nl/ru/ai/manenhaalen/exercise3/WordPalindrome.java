//Cody van Haalen s1075021
// Pepijn van Manen s484004
package nl.ru.ai.manenhaalen.exercise3;

import java.util.Scanner;

public class WordPalindrome
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Palindrome Checker");
        System.out.println("Please enter a word to see if it's a palindrome or not.");
        String inputString = input.next();
        int wordCount = inputString.length() - 1;
        System.out.println(inputString + ": " + wordCount);
        int startCount = 0;
        char first;
        char last;

        while(wordCount > -1)
        {
            first = inputString.charAt(startCount++);
            last = inputString.charAt(wordCount--);
            if (first != last)
            {
                System.out.println(inputString +" is not a palindrome.");
                wordCount = -1;
            }
            else if (wordCount <= 0)
            {
                System.out.println(inputString +" is a palindrome.");
                wordCount = -1;
            }
        }
    }
}
