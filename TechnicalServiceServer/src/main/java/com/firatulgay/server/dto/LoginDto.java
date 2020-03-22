package com.firatulgay.server.dto;

/**
 * Created by FiratUlgay on 29.12.2019.
 */
public class LoginDto {

    private long id;
    private String adi;
    private String sifre;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
