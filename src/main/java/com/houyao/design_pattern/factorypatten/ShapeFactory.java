package com.houyao.design_pattern.factorypatten;


import com.houyao.design_pattern.factorypatten.impl.Circle;
import com.houyao.design_pattern.factorypatten.impl.Rectangle;
import com.houyao.design_pattern.factorypatten.impl.Square;

/**
 * 复杂对象适合使用工厂模式，而简单对象，特别是只需要通过 new 就可以完成创建的对象，
 * 无需使用工厂模式。如果使用工厂模式，就需要引入一个工厂类，会增加系统的复杂度。
 */
public class ShapeFactory {

    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
