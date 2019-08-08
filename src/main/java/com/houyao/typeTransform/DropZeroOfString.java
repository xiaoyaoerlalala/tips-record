package com.houyao.typeTransform;

import java.math.BigDecimal;

/**
 * @Author: houyao
 * @Description:
 * @Date: Created in 11:26:25 2019/7/11
 */
public class DropZeroOfString {
    public static void main(String[] args) {
        //去掉字符串整数前的0
        String  str= "-0000000124567892523365.212354510";
        BigDecimal decimal = new BigDecimal(str);
        String newString = decimal.toString();
        System.out.println(newString);
    }
}
