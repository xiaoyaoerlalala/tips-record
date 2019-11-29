package com.houyao.design_pattern.factorypatten.impl;


import com.houyao.design_pattern.factorypatten.Shape;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

