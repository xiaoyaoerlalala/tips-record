package com.houyao.propertiesTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * @Author: houyao
 * @Description:直接读取properties文件，将内容存在内存中
 * @Date: Created in 18:10:02 2019/5/31
 */
public class GetProperties {
    private static Properties prop=null;

    /**
     * 读取配置文件
     * @return
     */
    public static String initInfo() {
        FileInputStream fis=null;
        if(prop==null)
            prop = new Properties(System.getProperties());
        URL resource = GetProperties.class.getResource("/");
        File file= new File(resource.getPath() + "properties/testProperties.properties");
        try {
            fis = new FileInputStream(file);
            prop.load(fis);
            System.setProperties(prop);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
    /**
     *  获取配置文件总的配置   配置文件在程序启动的时候已经放置到系统中
     * @param key  配置文件中的属性
     * @return
     */
    public static String getInfo(String key) {
        prop = System.getProperties();
        try {
            return (String) prop.get(key);
        } catch (Exception ex) {
            System.out.println("get info exception  ，please check file exists！");
        }
        return "";
    }
}
