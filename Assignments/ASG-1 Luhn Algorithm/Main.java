/*
  September 22nd 2025
  Nick Stoyanov
  ASG #1 Luhn Algorithm
*/

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        // Obtain user input and declare the scanner class
        Scanner input = new Scanner(System.in);
        int userInput = 0;

        // Run an infinite loop...
        while (true) {
          userInput = input.nextInt();

          // and we will break it so no more student numbers are collected if a zero is inputed.
          if (userInput == 0) {
            break;
          }
          
          // Ensure the student numbers are of appropriate length.
          if ((userInput >= 100000000) && (userInput <= 999999999)) {
             // We will add our values to here from each digit for the checksum.
             int preTotal = 0;
      
             // Keep a multiple that we will use to go through each digit
             int currentMultiple = 1;

             // Run once each of the nine digits
             for (int i = 0; i < 9; i++) {
               int digit = ((userInput % (currentMultiple * 10)) - (userInput % currentMultiple)) / currentMultiple;
        
               // Check if its an even digit so we can double it
               if (i % 2 != 0) {
                 
                 // Digits over 10 must have their individual digits split and added together
                 if ((digit * 2) >= 10) {
                   preTotal = preTotal + (digit * 2) / 10 + (digit * 2) % 10;
                 } else {
                   preTotal = preTotal + (digit * 2);
                 }
               } else {
                 preTotal = preTotal + digit;
               }

               // To go through each digit, we much multiply what number column we are working with
               currentMultiple = currentMultiple * 10;
             }

            // Use the summed up digits, verify, and print out based off final checksum
            if (preTotal % 10 != 0) {
              System.out.println("false");
            } else {
              System.out.println("true");
            }
          } else {
            System.out.println("wrong length");
          }
        }

        // Will always run once the program is terminated.
        System.out.print("Bye Bye");
    }
}