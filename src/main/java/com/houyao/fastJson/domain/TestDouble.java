package com.houyao.fastJson.domain;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;

/**
 * @Author: houyao
 * @Description:
 * @Date: Created in 17:32:36 2019/7/10
 */
public class TestDouble {
    public static void main(String[] args) {
        String str = "{\"amount\":\"+0000000220200010000.13347809\"}";
        Amount  amount = JSON.parseObject(str,Amount.class);
        BigDecimal bd = new BigDecimal(String.valueOf(amount.getAmount()));
        System.out.println(bd.toPlainString());
    }
}
