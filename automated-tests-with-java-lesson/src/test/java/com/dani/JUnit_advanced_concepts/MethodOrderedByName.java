package com.dani.JUnit_advanced_concepts;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Order(2)
@TestMethodOrder(MethodOrderer.MethodName.class) // roda o teste sempre pela ordem do nome do método
public class MethodOrderedByName {

    @Test
    void test3() {
        System.out.println("Test 3");
    }

    @Test
    void test4() {
        System.out.println("Test 4");
    }
    
    @Test
    void test1() {
        System.out.println("Test 1");
    }

    @Test
    void test2() {
        System.out.println("Test 2");
    }


}
