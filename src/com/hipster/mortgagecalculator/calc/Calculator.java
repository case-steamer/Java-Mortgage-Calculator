package com.hipster.mortgagecalculator.calc;

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

    // function
    public double calculateRate() {
        double ratePercentage = (annualInterest / 100)/12;
        double dividend = ratePercentage * (Math.pow((1 + ratePercentage), (totalYears * 12)));
        double divisor = Math.pow((1 + ratePercentage), (totalYears * 12)) - 1;
        double quotient = dividend / divisor;
        double product = principle * quotient;
        return product;
    }
}
