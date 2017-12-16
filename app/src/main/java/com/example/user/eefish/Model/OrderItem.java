package com.example.user.eefish.Model;

/**
 * Created by Rafif on 06/12/2017.
 */

public class OrderItem {

    private int order_item_id;
    private String price,order_kind,picture,weight,quantity,fish_item_name;

    public OrderItem(int order_item_id,
                     String price,
                     String order_kind,
                     String picture,
                     String weight,
                     String quantity,
                     String fish_item_name
    ) {
        this.order_item_id = order_item_id;
        this.price = price;
        this.order_kind = order_kind;
        this.picture = picture;
        this.weight = weight;
        this.quantity = quantity;
        this.fish_item_name = fish_item_name;
    }

    public int getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(int order_item_id) {
        this.order_item_id = order_item_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrder_kind() {
        return order_kind;
    }

    public void setOrder_kind(String order_kind) {
        this.order_kind = order_kind;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getFish_item_name() {
        return fish_item_name;
    }

    public void setFish_item_name(String fish_item_name) {
        this.fish_item_name = fish_item_name;
    }
}
