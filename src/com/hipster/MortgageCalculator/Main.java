package com.hipster.MortgageCalculator;

import com.hipster.MortgageCalculator.calc.Calculator;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner principleScan = new Scanner(System.in);
        Scanner interestScan = new Scanner(System.in);
        Scanner yearScan = new Scanner(System.in);

        int principle = 0;
         do {
            System.out.print("What is the principle? ");
            principle = principleScan.nextInt();
            if (principle < 1000 || principle > 1000000)
                System.out.println("Not a valid number. Enter a number between 1,000 & 1,000,000: ");
        } while (principle < 1000 || principle > 1000000);

         double interestRate = 0;
         do {
             System.out.print("What is the annual interest rate? ");
             interestRate = interestScan.nextDouble();
             if (interestRate <= 0 || interestRate > 30)
                 System.out.println("Not a valid number. Enter a number between 0 & 30: ");
         } while (interestRate <= 0 || interestRate > 30);

         int term = 0;
         do {
             System.out.println("What is the term of the mortgage? ");
             term = yearScan.nextInt();
             if (term <= 0 || term > 30)
                 System.out.println("Not a valid number. Enter a number between 0 & 30: ");
         } while (term <= 0 || term > 30);

        Calculator myRate = new Calculator(principle, interestRate, term);
        double monthlyPayment = myRate.calculateRate();
        DecimalFormat df = new DecimalFormat("0.00");
        String mp = df.format(monthlyPayment);
        System.out.println("Your monthly payment is $" + mp);
    }
}