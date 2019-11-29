package com.houyao.design_pattern.factorypatten.impl;


import com.houyao.design_pattern.factorypatten.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

