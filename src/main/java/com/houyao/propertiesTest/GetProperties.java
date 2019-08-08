package com.houyao.propertiesTest;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * @Author: houyao
 * @Description:直接读取properties文件，将内容存在内存中
 * @Date: Created in 18:10:02 2019/5/31
 */
public class GetProperties {
    private static Properties prop=null;

    public static String initInfoInJar() {
        FileInputStream fis=null;
        if(prop==null) {
            prop = new Properties(System.getProperties());
        }
        InputStream is = null;
        try {
            //通过getResourceAsStream方法可以获得jar包中文件的流，getResource只能读取文件系统的文件，读取jar包中的文件会报错
            is = GetProperties.class.getResourceAsStream("/conf/testProperties.properties");
            prop.load(is);
            System.setProperties(prop);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    /**
     * 读取配置文件
     * @return
     */
    public static String initInfo() {
        FileInputStream fis=null;
        if(prop==null)
            prop = new Properties(System.getProperties());
        /**
        * ClassLoader 提供了两个方法用于从装载的类路径中取得资源：
        * public URL  getResource (String name);
        * public InputStream  getResourceAsStream (String name);
        * 但是真正使用的不是ClassLoader的这两个方法，而是Class的 getResource和getResourceAsStream方法
        * 因为Class对象可以从你的类得到（如YourClass.class或 YourClass.getClass()）
        * 而ClassLoader则需要再调用一次YourClass.getClassLoader()方法
        * 不过根据JDK文档的说法，Class对象的这两个方法其实是“委托”（delegate）给装载它的ClassLoader来做的
        * 所以只需要使用 Class对象的这两个方法就可以了
        * this.getClass().getResourceAsStream(String name) ;获取流，
        * 静态化方法中则使用ClassLoader.getSystemResourceAsStream (String name) ;
        */
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
