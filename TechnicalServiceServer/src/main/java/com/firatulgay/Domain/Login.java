package com.firatulgay.Domain;

import javax.persistence.*;

/**
 * Created by FiratUlgay on 20.12.2019.
 */
@Entity
@Table(name="LOGIN")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50)
    private String adi;

    @Column (length = 50)
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
