package com.dani.rest_with_spring_boot_and_java.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Greeting {

    private Long id;
    private String name;  


    public Greeting(Long id, String name) {
        this.id = id;
        this.name = name;
    }


}
