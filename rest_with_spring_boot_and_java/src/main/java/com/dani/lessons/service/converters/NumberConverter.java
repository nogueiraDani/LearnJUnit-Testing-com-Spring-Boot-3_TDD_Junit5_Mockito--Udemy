package com.dani.lessons.service.converters;

import org.springframework.stereotype.Service;

import com.dani.lessons.exceptions.ResourceNotFoundException;
import com.dani.lessons.service.validations.NumberValidation;

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
            throw new ResourceNotFoundException("Valor inválido: " + strNumber);
        }

        // corrigindo valores com , para valor com .
        return Double.parseDouble(strNumber.replace(",", "."));

    }

}
