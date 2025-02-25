package com.dani.rest_with_spring_boot_and_java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dani.rest_with_spring_boot_and_java.service.MathService;
import com.dani.rest_with_spring_boot_and_java.service.converters.NumberConverter;

@RestController
public class MathController {

        @Autowired
        private MathService mathService;
        @Autowired
        private NumberConverter numberConverter;

        @GetMapping("/sum/{numberOne}/{numberTwo}")
        public String getSum(
                        @PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

                String operation = "+";

                return mathService.generateResult(
                                numberConverter.convertToDouble(numberOne),
                                numberConverter.convertToDouble(numberTwo),
                                operation);

        }

        @GetMapping("/subtraction/{numberOne}/{numberTwo}")
        public String getSubtration(
                        @PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
                String operation = "-";

                return mathService.generateResult(
                                numberConverter.convertToDouble(numberOne),
                                numberConverter.convertToDouble(numberTwo),
                                operation);

        }

        @GetMapping("/multiplication/{numberOne}/{numberTwo}")
        public String getMultiplication(
                        @PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
                String operation = "*";

                return mathService.generateResult(
                                numberConverter.convertToDouble(numberOne),
                                numberConverter.convertToDouble(numberTwo),
                                operation);

        }

        @GetMapping("/division/{numberOne}/{numberTwo}")
        public String getDivision(
                        @PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
                String operation = "/";

                return mathService.generateResult(
                                numberConverter.convertToDouble(numberOne),
                                numberConverter.convertToDouble(numberTwo),
                                operation);

        }

        @GetMapping("/average/{numberOne}/{numberTwo}")
        public String getAverage(
                        @PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

                return mathService.generateAverage(
                                numberConverter.convertToDouble(numberOne),
                                numberConverter.convertToDouble(numberTwo));

        }

        @GetMapping("/squareRoot/{number}")
        public String getSquareRoot(
                        @PathVariable(value = "number") String number) throws Exception {

                return mathService.generateSquareRoot(
                                numberConverter.convertToDouble(number));

        }

}
