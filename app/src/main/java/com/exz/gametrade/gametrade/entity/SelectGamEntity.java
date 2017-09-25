package com.exz.gametrade.gametrade.entity;

import java.util.List;

/**
 * Created by pc on 2017/9/19.
 */

public class SelectGamEntity {


    /**
     * letter : A
     * letterList : [{"name":"艾尔战记"},{"name":"暗黑力量"}]
     */

    private String letter;
    private List<LetterListBean> letterList;

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public List<LetterListBean> getLetterList() {
        return letterList;
    }

    public void setLetterList(List<LetterListBean> letterList) {
        this.letterList = letterList;
    }

    public static class LetterListBean {
        /**
         * name : 艾尔战记
         */

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
