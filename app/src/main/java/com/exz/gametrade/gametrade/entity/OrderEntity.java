package com.exz.gametrade.gametrade.entity;

/**
 * Created by pc on 2017/9/19.
 */

public class OrderEntity {
    String orderNum;
    String state;
    String num;
    String price;


    public OrderEntity( String state, String num) {
        this.state = state;
        this.num = num;
    }



    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
