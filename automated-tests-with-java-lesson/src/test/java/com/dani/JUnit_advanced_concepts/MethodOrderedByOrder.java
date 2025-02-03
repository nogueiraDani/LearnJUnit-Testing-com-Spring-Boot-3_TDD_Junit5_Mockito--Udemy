package com.dani.JUnit_advanced_concepts;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Order(3)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // roda o teste sempre pela ordem do Order
public class MethodOrderedByOrder {

    @Test
    @Order(4)
    void test3() {
        System.out.println("Test 3");
    }

    @Test
    @Order(1)
    void test4() {
        System.out.println("Test 4");
    }
    
    @Test
    @Order(2)
    void test1() {
        System.out.println("Test 1");
    }

    @Test
    @Order(3)
    void test2() {
        System.out.println("Test 2");
    }


}
