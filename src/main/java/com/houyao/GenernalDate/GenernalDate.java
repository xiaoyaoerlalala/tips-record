package com.houyao.GenernalDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: houyao
 * @Description:关于日期的一些操作
 * @Date: Created in 10:33:57 2019/5/31
 */
public class GenernalDate {
    public static void main(String[] args) throws ParseException{
        System.out.println(getSpecifiedMillis());
        System.out.println(changDate("2019-07-27 00:00:00"));
    }

    /**
    * @Description: 获取当前日期的字符串
    * @auther: houyao
    * @date: 10:36:13 2019/5/31
    * @param: []
    * @return: java.lang.String
    *
    */
    public static String getNowDate() {
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
        calendar.set(2019,6,27);
        long millis = calendar.getTimeInMillis();
        return millis;
    }

    /**
     * 日期字符串转换成毫秒
     * @param time
     * @return
     * @throws ParseException
     */
    public static Long changDate(String time) throws ParseException {
        //字符串格式：String dateTime = "2016-12-31 12:30:45 123";
        Calendar calendar = Calendar.getInstance();
        //calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse(dateTime));
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time));
        return calendar.getTimeInMillis();
    }

    /**
     * 获得指定秒数后的日期字符串
     * @param specifiedSeconds
     * @return
     */
    public static String getSpecifiedSecondAfter(String specifiedSeconds) {
        String fullDetailDateTime = getNowDate();
        Calendar calendar = Calendar.getInstance();
        try{
            calendar.setTime(new SimpleDateFormat("yyyyMMddHHmmss").parse(fullDetailDateTime));
            int second = calendar.get(Calendar.SECOND);
            calendar.set(Calendar.SECOND, second + Integer.valueOf(specifiedSeconds));
        }catch (Exception e){

        }
        String dayAfter = new SimpleDateFormat("YYYYMMddHHmmss").format(calendar.getTime());
        return dayAfter;
    }

    /**
     * 获得指定天数后的日期字符串
     * @param dates
     * @return
     */
    public static String getSpecifiedDateAfter(String dates) {
        String fullDetailDateTime = getNowDate();
        Calendar calendar = Calendar.getInstance();
        try{
            calendar.setTime(new SimpleDateFormat("yyyyMMdd").parse(fullDetailDateTime));
            int date = calendar.get(Calendar.DATE);
            calendar.set(Calendar.DATE, date + Integer.valueOf(dates));
        }catch (Exception e){

        }
        String dayAfter = new SimpleDateFormat("YYYYMMddHHmmss").format(calendar.getTime());
        return dayAfter;
    }

    /**
     * 获得指定天数后的日期字符串
     * @param days
     * @return
     */
    public static String getSpecifiedDateAfter(String dateStr, String days) {
        Calendar calendar = Calendar.getInstance();
        try{
            calendar.setTime(new SimpleDateFormat("yyyyMMdd").parse(dateStr));
            int date = calendar.get(Calendar.DATE);
            calendar.set(Calendar.DATE, date + Integer.valueOf(days));
        }catch (Exception e){

        }
        String dayAfter = new SimpleDateFormat("YYYYMMdd").format(calendar.getTime());
        return dayAfter;
    }

    /**
     * 获得指定月数后的日期字符串
     * @param months
     * @return
     */
    public static String getSpecifiedMonthAfter(String dateStr, String months) {
        Calendar calendar = Calendar.getInstance();
        try{
            calendar.setTime(new SimpleDateFormat("yyyyMMdd").parse(dateStr));
            int month = calendar.get(Calendar.MONTH);
            calendar.set(Calendar.MONTH, month + Integer.valueOf(months));
        }catch (Exception e){

        }
        String monthAfter = new SimpleDateFormat("YYYYMMdd").format(calendar.getTime());
        return monthAfter;
    }
}
