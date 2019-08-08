package com.houyao.fileTools;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * @Author: houyao
 * @Description:在指定的目录中新建文件，并指定最后修改时间
 * @Date: Created in 11:40:40 2019/6/10
 */
public class SetLastModified {

    public static void main(String[] args) {
        test();
    }
    /**
    * @Description: 在指定目录中新建文件test.txt,并指定最后修改时间
    * @auther: houyao
    * @date: 11:45:32 2019/6/10
    * @param: []
    * @return: void
    *
    */
    public static void test(){
        File file = new File("D:\\config\\hkbet_interface\\bak\\HKA0510D.m37.gz-20190510");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        //月份设置时0-11对应1-12月
        calendar.set(2019,4,10);
        long millis = calendar.getTimeInMillis();
        file.setLastModified(millis);
    }

}
