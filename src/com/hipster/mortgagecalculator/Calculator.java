package com.hipster.mortgagecalculator;

import java.text.DecimalFormat;

// class declaration
public class Calculator {
    private int principle;
    private double annualInterest;
    private int totalYears;

    // constructor
    public Calculator(int principle, double annualInterest, int totalYears) {
        this.principle = principle;
        this.annualInterest = annualInterest;
        this.totalYears = totalYears;
    }

    // function: calculate monthly payment
    public double calculateRate() {
        double ratePercentage = (annualInterest / 100)/12;
        double dividend = ratePercentage * (Math.pow((1 + ratePercentage), (totalYears * 12)));
        double divisor = Math.pow((1 + ratePercentage), (totalYears * 12)) - 1;
        double quotient = dividend / divisor;
        double product = principle * quotient;
        return product;
    }

    // function: amortization schedule
    // requires a for loop that calculates totalMonths - monthsPaid
    public String paymentSchedule(int monthsPaid, DecimalFormat format) {
        //B = L[(1 + c)n - (1 + c)p]/[(1 + c)n - 1]
        //L = principle
        //c = ratePercentage = interest rate
        //n = term of the loan in months
        //p = monthsPaid = months already paid
        //for months in n:
        //    print B
        double ratePercentage = (annualInterest / 100)/12;
        double dividend = Math.pow((ratePercentage + 1), (totalYears * 12)) - Math.pow((ratePercentage + 1), monthsPaid);
        double divisor = Math.pow((ratePercentage + 1), (totalYears * 12)) - 1;
        double quotient = dividend / divisor;
        double product = principle * quotient;
        String delivery = format.format(product);
        return delivery;
    }
}
