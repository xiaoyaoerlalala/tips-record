package com.houyao.fastJson.domain;

/**
 * @Author: houyao
 * @Description:
 * @Date: Created in 17:38:06 2019/7/10
 */
public class Amount {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "amount=" + amount +
                '}';
    }
}
