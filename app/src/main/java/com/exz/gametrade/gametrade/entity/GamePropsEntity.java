package com.exz.gametrade.gametrade.entity;

/**
 * Created by pc on 2017/9/18.
 */

public class GamePropsEntity {
    String title;
    String subTitle;
    String price;
    String stock;
    boolean check;

    public GamePropsEntity(String title, String subTitle, String price, String stock) {
        this.title = title;
        this.subTitle = subTitle;
        this.price = price;
        this.stock = stock;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
