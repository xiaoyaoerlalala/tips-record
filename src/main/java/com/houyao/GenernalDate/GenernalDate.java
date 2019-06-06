package com.houyao.GenernalDate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: houyao
 * @Description:关于日期的一些操作
 * @Date: Created in 10:33:57 2019/5/31
 */
public class GenernalDate {
    /**
    * @Description: 获取当前日期的字符串
    * @auther: houyao
    * @date: 10:36:13 2019/5/31
    * @param: []
    * @return: java.lang.String
    *
    */
    public static String getNowDate(){
        Date now=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowString=dateFormat.format(now);
        return nowString;
    }

    public static void main(String[] args) {
        System.out.println(getNowDate());
    }
}
