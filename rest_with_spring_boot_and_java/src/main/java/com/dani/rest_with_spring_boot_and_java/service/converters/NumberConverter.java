package com.dani.rest_with_spring_boot_and_java.service.converters;

import org.springframework.stereotype.Service;

import com.dani.rest_with_spring_boot_and_java.exceptions.UnsupportedMathOperationException;
import com.dani.rest_with_spring_boot_and_java.service.validations.NumberValidation;

@Service
public class NumberConverter {
    
    private NumberValidation numberValidation = new NumberValidation();

    public NumberConverter() {
    }

    public Double convertToDouble(String strNumber) throws Exception {

        // validando valor nulo
        if (strNumber == null) {
            throw new IllegalArgumentException("Valor inválido: " + strNumber);
        }
        if (!numberValidation.isNumeric(strNumber)) {
            throw new UnsupportedMathOperationException("Valor inválido: " + strNumber);
        }

        // corrigindo valores com , para valor com .
        return Double.parseDouble(strNumber.replace(",", "."));

    }

}
