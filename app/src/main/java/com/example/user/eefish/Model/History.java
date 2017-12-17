package com.example.user.eefish.Model;

/**
 * Created by Nadian on 12/16/2017.
 */

public class History {
    private String orderKind;
    private String orderDate;
    private String orderTotal;
    private String orderShippingCost;
    private String orderStatusSucces;

    public String getOrderKind() {
        return orderKind;
    }

    public void setOrderKind(String orderKind) {
        this.orderKind = orderKind;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getOrderShippingCost() {
        return orderShippingCost;
    }

    public void setOrderShippingCost(String orderShippingCost) {
        this.orderShippingCost = orderShippingCost;
    }

    public String getOrderStatusSucces() {
        return orderStatusSucces;
    }

    public void setOrderStatusSucces(String orderStatusSucces) {
        this.orderStatusSucces = orderStatusSucces;
    }
}
