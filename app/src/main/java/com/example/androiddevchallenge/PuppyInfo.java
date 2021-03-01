package com.example.androiddevchallenge;

import androidx.compose.ui.graphics.painter.Painter;

import java.io.Serializable;

public class PuppyInfo implements Serializable{
    private int age;
    private String name;
    private String publisher;
    private String desc;
    private int imageRes;

    public PuppyInfo(int age, String name, String publisher, String desc, int imageRes) {
        this.age = age;
        this.name = name;
        this.publisher = publisher;
        this.desc = desc;
        this.imageRes = imageRes;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDesc() {
        return desc;
    }

    public int getImageRes() {
        return imageRes;
    }
}
