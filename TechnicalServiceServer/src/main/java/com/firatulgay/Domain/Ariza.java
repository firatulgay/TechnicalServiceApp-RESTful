package com.firatulgay.Domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by FiratUlgay on 20.12.2019.
 */
@Entity
@Table(name = "ARIZA")
public class Ariza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50)
    private String adi;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(length = 50)
    private String content;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private EnumState enumState;

    @Column(length = 50)
    private String description;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EnumState getEnumState() {
        return enumState;
    }

    public void setEnumState(EnumState enumState) {
        this.enumState = enumState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return adi;
    }
}
