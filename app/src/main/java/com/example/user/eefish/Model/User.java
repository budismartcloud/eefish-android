package com.example.user.eefish.Model;

/**
 * Created by Rafif on 03/10/2017.
 */
public class User {
    int id;
    String username,name,password,identity_number,address,phone_number,email,postcode;

    public User(int id, String username, String name, String password, String identity_number, String address, String phone_number, String email, String postcode) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.identity_number = identity_number;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.postcode = postcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity_number() {
        return identity_number;
    }

    public void setIdentity_number(String identity_number) {
        this.identity_number = identity_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
