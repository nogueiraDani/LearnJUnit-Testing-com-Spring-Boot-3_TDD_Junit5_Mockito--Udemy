package com.dani.lessons.service.validations;

public class NumberValidation {

    public NumberValidation() {
    }

    public boolean isNumeric(String strNumber) {

        // corrigindo valores com , para valor com .
        String number = strNumber.replaceAll(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
