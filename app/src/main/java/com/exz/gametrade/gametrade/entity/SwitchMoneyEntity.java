package com.exz.gametrade.gametrade.entity;

/**
 * Created by pc on 2017/9/20.
 */

public class SwitchMoneyEntity {
    String name;
    boolean check;

    public SwitchMoneyEntity(String name, boolean check) {
        this.name = name;
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
