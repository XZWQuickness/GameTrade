package com.exz.gametrade.gametrade.entity;

/**
 * Created by pc on 2017/9/19.
 */

public class PopSingleEntity {
    String name;
    boolean check;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public PopSingleEntity(String name,boolean check) {
        this.name = name;
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
