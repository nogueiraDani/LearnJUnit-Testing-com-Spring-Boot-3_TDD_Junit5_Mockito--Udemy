package com.dani.JUnit_advanced_concepts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // define o clico de vida da instância de teste como 1 por classe
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByOrderIndexTest {
    
    StringBuilder actualValue = new StringBuilder();


    @AfterEach
    void afterEach() {
        System.out.println(actualValue);
    }

    @Test
    @Order(2)
    void secondTest() {
        actualValue.append("2");
    }

    @Test
    @Order(1)
    void firstTest() {
        actualValue.append("1");
    }

    @Test
    @Order(3)
    void thirdTest() {
        actualValue.append("3");
    }

    @Test
    @Order(4)
    void fourthTest() {
        actualValue.append("4");
    }

}
