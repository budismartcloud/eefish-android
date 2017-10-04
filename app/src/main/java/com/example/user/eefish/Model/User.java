package com.example.user.eefish.Model;

/**
 * Created by Rafif on 03/10/2017.
 */
public class User {
    private int id,kodepos;
    private String email,password,nama,alamat,noktp,username,telepon;

    public User(int id, int kodepos, String email, String password, String nama, String alamat, String noktp, String username, String telepon) {
        this.id = id;
        this.kodepos = kodepos;
        this.email = email;
        this.password = password;
        this.nama = nama;
        this.alamat = alamat;
        this.noktp = noktp;
        this.username = username;
        this.telepon = telepon;
    }

    public int getKodepos() {
        return kodepos;
    }

    public void setKodepos(int kodepos) {
        this.kodepos = kodepos;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoktp() {
        return noktp;
    }

    public void setNoktp(String noktp) {
        this.noktp = noktp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {

        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
