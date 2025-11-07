//A REPOSITORY HAS BEEN CREATED FOR THIS PROJECT. DO NOT CHANGE CODE ON MASTER. MAKE A BRANCH!!!
// git branch <your-project-here>

package com.hipster.mortgagecalculator;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int principle = (int) readNumber("What is the principle? ", 1, 1_000_000);

        double interestRate = readNumber("What is the annual interest rate? ", 0, 30);

        int term = (int) readNumber("What is the term of the mortgage? ", 0, 30);

        Calculator myRate = new Calculator(principle, interestRate, term);
        double monthlyPayment = myRate.calculateRate();
        DecimalFormat df = new DecimalFormat("0.00");
        String mp = df.format(monthlyPayment);
        System.out.println("Your monthly payment is $" + mp);
    }


    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        do {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value <= min || value > max)
                System.out.println("Not a valid number. Enter a number between " + min + " and " + max + ": ");
        } while (value <= min || value > max);
        return value;
    }
}