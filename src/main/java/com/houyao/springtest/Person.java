package com.houyao.springtest;

import org.springframework.stereotype.Component;

@Component
public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}