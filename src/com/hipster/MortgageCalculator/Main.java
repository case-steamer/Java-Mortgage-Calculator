package com.hipster.MortgageCalculator;

import com.hipster.MortgageCalculator.calc.Calculator;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner principleScan = new Scanner(System.in);
        Scanner interestScan = new Scanner(System.in);
        Scanner yearScan = new Scanner(System.in);
        System.out.print("What is the principle? ");
        int principle = principleScan.nextInt();
        System.out.print("What is the annual interest rate? ");
        double interestRate = interestScan.nextDouble();
        System.out.println("What is the term of the mortgage? ");
        int term = yearScan.nextInt();

        Calculator myRate = new Calculator(principle, interestRate, term);
        double monthlyPayment = myRate.calculateRate();
        DecimalFormat df = new DecimalFormat("0.00");
        String mp = df.format(monthlyPayment);
        System.out.println("Your monthly payment is $" + mp);
    }
}