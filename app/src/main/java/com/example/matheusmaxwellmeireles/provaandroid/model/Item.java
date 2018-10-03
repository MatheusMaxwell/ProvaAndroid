package com.example.matheusmaxwellmeireles.provaandroid.model;

import java.io.Serializable;

public class Item implements Serializable{


    private String desc;
    private int image;
    private boolean check;

    public Item(String desc, int image, boolean check) {

        this.desc = desc;
        this.image = image;
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }



    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
