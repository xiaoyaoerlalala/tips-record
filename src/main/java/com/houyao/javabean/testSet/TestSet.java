package com.houyao.javabean.testSet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author: houyao
 * @Description:
 * @Date: Created in 10:27:04 2019/9/4
 */
public class TestSet {
    private static final String  JSON_OBJ_STR = "{\"name\":\"lily\"}";
    public static void main(String[] args) {
        JSON.parseObject(JSON_OBJ_STR, People.class);
    }
}
