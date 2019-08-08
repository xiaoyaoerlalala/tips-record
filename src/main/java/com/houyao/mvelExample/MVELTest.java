package com.houyao.mvelExample;

import org.mvel2.MVEL;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: houyao
 * @Description:
 * @Date: Created in 18:56:29 2019/7/12
 */
public class MVELTest {
    public static void main(String[] args) {
        String expression = "foobar > 99";

        Map vars = new HashMap();
        vars.put("foobar", new Integer(100));

        // We know this expression should return a boolean.
        Boolean result = (Boolean) MVEL.eval(expression, vars);

        if (result.booleanValue()) {
            System.out.println("It works!");
        }
    }
}
