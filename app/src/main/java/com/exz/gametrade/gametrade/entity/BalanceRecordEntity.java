package com.exz.gametrade.gametrade.entity;

/**
 * Created by pc on 2017/9/20.
 */

public class BalanceRecordEntity {


    /**
     * title : 支付宝账号充值
     * date : 2017-9-12 12:00
     *  money : ￥100
     * isIncrease : 0
     */

    private String title;
    private String date;
    private String money;
    private String isIncrease;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getIsIncrease() {
        return isIncrease;
    }

    public void setIsIncrease(String isIncrease) {
        this.isIncrease = isIncrease;
    }
}
