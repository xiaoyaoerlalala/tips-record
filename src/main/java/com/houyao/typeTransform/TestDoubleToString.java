package com.houyao.typeTransform;

import java.math.BigDecimal;

import static javafx.scene.input.KeyCode.M;

/**
 * @Author: houyao
 * @Description:
 * @Date: Created in 11:41:41 2019/7/4
 */
public class TestDoubleToString {
    public static void main(String[] args) {
        double a = 0.1223140;
        String f = String.valueOf(a);
        System.out.println(f);

        //给一个字符串1.238761976E-10
        //如何得到0.0000000001238761976这个字符串呢？
        BigDecimal bd = new BigDecimal("2.2020001000013348E11");
        System.out.println(bd.toPlainString());
    }
}
