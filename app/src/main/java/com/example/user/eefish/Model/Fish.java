package com.example.user.eefish.Model;

/**
 * Created by Rafif on 13/10/2017.
 */

public class Fish {
    private int fish_id,variety_id;
    private String fish_name;
    private String quantity;
    private String category_id;
    private String weight;
    private String variety_name;
    private String singular_price;
    private String colective_price;
    private String category_name;

    public String getPicture_fish() {
        return picture_fish;
    }

    public void setPicture_fish(String picture_fish) {
        this.picture_fish = picture_fish;
    }

    private String picture_fish;

    public String getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Fish(int fish_id, String weight, int variety_id, String quantity, String category_id, String fish_name, String variety_name, String singular_price, String colective_price, String category_name, String picture_fish) {
        this.fish_id = fish_id;
        this.weight = weight;
        this.variety_id = variety_id;
        this.quantity = quantity;
        this.category_id = category_id;
        this.fish_name = fish_name;
        this.variety_name = variety_name;
        this.singular_price = singular_price;
        this.colective_price = colective_price;
        this.category_name = category_name;
        this.picture_fish = picture_fish;
    }


    public int getFish_id() {
        return fish_id;
    }

    public void setFish_id(int fish_id) {
        this.fish_id = fish_id;
    }


    public int getVariety_id() {
        return variety_id;
    }

    public void setVariety_id(int variety_id) {
        this.variety_id = variety_id;
    }


    public String getFish_name() {
        return fish_name;
    }

    public void setFish_name(String fish_name) {
        this.fish_name = fish_name;
    }

    public String getVariety_name() {
        return variety_name;
    }

    public void setVariety_name(String variety_name) {
        this.variety_name = variety_name;
    }

    public String getSingular_price() {
        return singular_price;
    }

    public void setSingular_price(String singular_price) {
        this.singular_price = singular_price;
    }

    public String getColective_price() {
        return colective_price;
    }

    public void setColective_price(String colective_price) {
        this.colective_price = colective_price;
    }
}
