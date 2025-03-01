package com.dani.lessons.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public MathService() {
    }

    private static final String template = "%.2f %s %.2f = %.2f";

    public String generateResult(Double numberOneDouble, Double numberTwoDouble, String operation) {

        Double result = 0.0d;

        switch (operation) {
            case "+":
                result = numberOneDouble + numberTwoDouble;
                break;
            case "-":
                result = numberOneDouble - numberTwoDouble;
                break;
            case "*":
                result = numberOneDouble * numberTwoDouble;
                break;
            case "/":
                result = numberOneDouble / numberTwoDouble;
                break;

            default:
                break;
        }

        return String.format(template, numberOneDouble, operation , numberTwoDouble, result);

    }

    public String generateAverage(Double numberOneDouble, Double numberTwoDouble) {
        
        Double result = (numberOneDouble + numberTwoDouble) / 2;
        return "The average of " + numberOneDouble + " and " + numberTwoDouble + " = " + result;
    }

    public String generateSquareRoot(Double number) {
        
        Double result = Math.sqrt(number);
        return "The square root of " + number + " = " + result;
    }

    

    

}
