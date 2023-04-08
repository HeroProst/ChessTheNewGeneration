package com.example.cours_project.SupportClass;

public class ListFigure {
    public int imageId;
    public String name;
    public String tag;
    public int price;

    public ListFigure(int imageId, String name, String tag, int price) {
        this.imageId = imageId;
        this.name = name;
        this.tag = tag;
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
