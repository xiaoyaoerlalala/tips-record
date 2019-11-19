package com.houyao.GenernalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
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
    /**
     * 转换日期格式时"yyyy"尽量都用小写，不要用大写，YYYY是根据周计算年份的，取当天所在周所属年份，一周从周日开始计算
     * 周六结束，本周只要跨年，那么这周属于下一年
     */
    private static final Logger logger = LoggerFactory.getLogger(GenernalDate.class);

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
        String dayAfter = new SimpleDateFormat("yyyyMMddHHmmss").format(calendar.getTime());
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
        String dayAfter = new SimpleDateFormat("yyyyMMddHHmmss").format(calendar.getTime());
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
        String dayAfter = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
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
        String monthAfter = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
        return monthAfter;
    }

    /**
     * 如果date是周末，取date的前一天，直到得到的日期不是周末为止
     * @param date
     * @return
     */
    public static String getOneWorkingDayBefore(String date) {
        String tempDate = getSpecifiedDateBefore(date, "1");
        if (isWeekend(tempDate)) {
            tempDate = getOneWorkingDayBefore(tempDate);
            return tempDate;
        } else {
            return tempDate;
        }
    }

    /**
     * 如果date是周末，取date的后一天，直到得到的日期不是周末为止
     * @param date
     * @return
     */
    public static String getOneWorkingDayAfter(String date) {
        String tempDate = getSpecifiedDateAfter(date, "1");
        if (isWeekend(tempDate)) {
            tempDate = getOneWorkingDayAfter(tempDate);
            return tempDate;
        } else {
            return tempDate;
        }
    }

    /**
     * 计算date前n天的工作日
     * @return
     */
    public static String getNWorkingDayBefore(String date, int n) {
        String tempDate = date;
        for (int i = 0; i < n; i++) {
            tempDate = getOneWorkingDayBefore(tempDate);
        }
        return tempDate;
    }

    /**
     * 计算date后n天的工作日
     * @return
     */
    public static String getNWorkingDayAfter(String date, int n) {
        String tempDate = date;
        for (int i = 0; i < n; i++) {
            tempDate = getOneWorkingDayAfter(tempDate);
        }
        return tempDate;
    }

    /**
     * 获得某年某月的最后一天
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
        return new SimpleDateFormat("yyyyMMdd ").format(cal.getTime());
    }

    /**
     * 获得指定天数前的日期字符串
     * @param days
     * @return
     */
    public static String getSpecifiedDateBefore(String dateStr, String days) {
        Calendar calendar = Calendar.getInstance();
        try{
            calendar.setTime(new SimpleDateFormat("yyyyMMdd").parse(dateStr));
            int date = calendar.get(Calendar.DATE);
            calendar.set(Calendar.DATE, date - Integer.valueOf(days));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        String dayAfter = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
        return dayAfter;
    }

    /**
     * 判断是否周末
     * @param bDate
     * @return
     * @throws ParseException
     */
    public static boolean isWeekend(String bDate) {
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date bdate = null;
        try {
            bdate = format.parse(bDate);
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(bdate);
        if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            return true;
        }
        return false;
    }

}
