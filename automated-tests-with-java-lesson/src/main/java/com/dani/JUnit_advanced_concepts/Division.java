package com.dani.JUnit_advanced_concepts;

public class Division {

    public Double division(Double firstNumber, Double secondNumber) {
        if (secondNumber.equals(0D))
            throw new ArithmeticException("Impossible to divide by zero!");
        return firstNumber / secondNumber;
    }

}
