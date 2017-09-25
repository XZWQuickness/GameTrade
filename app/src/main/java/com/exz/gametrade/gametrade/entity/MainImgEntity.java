package com.exz.gametrade.gametrade.entity;

/**
 * Created by pc on 2017/9/18.
 */

public class MainImgEntity {
    String img;
    String title;




    public  MainImgEntity(String title, String img) {
        this.title = title;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
