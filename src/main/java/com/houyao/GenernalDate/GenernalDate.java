package com.houyao.GenernalDate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: houyao
 * @Description:关于日期的一些操作
 * @Date: Created in 10:33:57 2019/5/31
 */
public class GenernalDate {
    public static void main(String[] args) {
        System.out.println(getNowDate());
    }

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
    /**
    * @Description: 获取指定时间的long类型毫秒数
    * @auther: houyao
    * @date: 11:36:16 2019/6/10
    * @param: []
    * @return: long
    *
    */
    public static long getSpecifiedMillis(){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        //注意此处有坑：0表示1月，1表示2月，以此类推
        calendar.set(2018,0,1);
        long millis = calendar.getTimeInMillis();
        return millis;
    }
}
