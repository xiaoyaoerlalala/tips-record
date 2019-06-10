package com.houyao.collection.ConcurrentModificationException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: houyao
 * @Description:List和Map等集合不能一边遍历一边进行修改，否则会导致ConcurrentModificationException
 * @Date: Created in 9:14:34 2019/6/10
 */
public class MapExample {
    public static void main(String[] args) {
        //errorExample();
        correctExample();
    }
    /**
    * @Description: 示例错误的遍历Map导致ConcurrentModificationException异常
    * @auther: houyao
    * @date: 9:18:26 2019/6/10
    * @param: []
    * @return: void
    *
    */
    public static void errorExample(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "test1");
        map.put("2", "test2");
        for(HashMap.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey();
            if("1".equals(key)){
                map.remove(key);
            }
        }
    }

    public static void correctExample(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "test1");
        map.put("2", "test2");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            if("1".equals(key)){
                iterator.remove();
            }
        }
    }
}
