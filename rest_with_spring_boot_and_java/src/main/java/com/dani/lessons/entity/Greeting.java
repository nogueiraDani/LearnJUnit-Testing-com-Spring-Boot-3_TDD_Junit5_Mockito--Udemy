package com.dani.lessons.entity;

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
