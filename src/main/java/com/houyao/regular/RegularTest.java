package com.houyao.regular;

public class RegularTest {
    public static void main(String[] args) {

    }

    //+：代表的是匹配加号(+)之前的正则表达式1次或多次。
    //(：匹配小括号内的字符串，可以是一个，也可以是多个
    //[：匹配字符组内的字符，比如咱们常用的[0-9a-zA-Z.*?!]等，在[]内的字符都是字符，不是元字符，比如“0-9”、“a-z”这中间的“-”就是连接符号，表示范围的元字符
    //?：匹配前面的一次或者0次

    /**
     * 判断是不是数字（包含浮点类型）
     * @param str
     * @return
     */
    public static boolean isNumber(String str){
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }
}
