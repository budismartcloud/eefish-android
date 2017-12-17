package com.example.user.eefish.Model;

/**
 * Created by Nadian on 12/16/2017.
 */

public class History {

    private int orderID;
    private int idUser;
    private String orderKind;
    private String orderDate;
    private String orderTotal;
    private String orderShippingCost;
    private String orderStatus;

    public History(int orderID, int idUser, String orderKind, String orderDate, String orderTotal, String orderShippingCost, String orderStatus) {
        this.orderID = orderID;
        this.idUser = idUser;
        this.orderKind = orderKind;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.orderShippingCost = orderShippingCost;
        this.orderStatus = orderStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatusSucces) {
        this.orderStatus = orderStatusSucces;
    }
}
