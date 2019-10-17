package com.houyao.collection.foreach;

import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @Author: houyao
 * @Description:
 * @Date: Created in 11:57:39 2019/8/8
 */
public class ForeachList {
    public static void main(String[] args) {
        //使用com.google.guava包创建集合
        /*List<String> list = Lists.newArrayList("a","b","c","d");

        //遍历1  其中anyThing可以用其它字符替换
        list.forEach((anyThing)->System.out.println(anyThing));
        //遍历2
        list.forEach(any->System.out.println(any));
        //匹配输出 : "b"
        list.forEach(item->{
            if("b".equals(item)){
                System.out.println(item);
            }
        });*/
    }
}
