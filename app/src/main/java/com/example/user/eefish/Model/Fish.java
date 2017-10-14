package com.example.user.eefish.Model;

/**
 * Created by Rafif on 13/10/2017.
 */

public class Fish {
    private int id_fish,weight,variety_id,quantity, category_id;
    private String fish_name,variety_name,singular_price, colective_price, category_name;

    public Fish(int id_fish, int weight, int variety_id, int quantity, int category_id, String fish_name, String variety_name, String singular_price, String colective_price, String category_name) {
        this.id_fish = id_fish;
        this.weight = weight;
        this.variety_id = variety_id;
        this.quantity = quantity;
        this.category_id = category_id;
        this.fish_name = fish_name;
        this.variety_name = variety_name;
        this.singular_price = singular_price;
        this.colective_price = colective_price;
        this.category_name = category_name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getId_fish() {
        return id_fish;
    }

    public void setId_fish(int id_fish) {
        this.id_fish = id_fish;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getVariety_id() {
        return variety_id;
    }

    public void setVariety_id(int variety_id) {
        this.variety_id = variety_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
