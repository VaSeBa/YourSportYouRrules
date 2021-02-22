package ru.vaseba.yoursportyourrules.myex;

import java.util.Random;
import java.util.UUID;

public class MyExes {
    private UUID mId;
    private String name;
    private String detail;
    private int img;

    public MyExes() {
        mId = UUID.randomUUID();
    }

    public MyExes(UUID id) {
        mId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
