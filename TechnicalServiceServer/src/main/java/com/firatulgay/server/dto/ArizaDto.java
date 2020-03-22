package com.firatulgay.server.dto;

import com.firatulgay.Domain.EnumState;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.Date;

/**
 * Created by FiratUlgay on 26.12.2019.
 */
public class ArizaDto {

    private long id ;

    private String adi;

    private Date date;

    private String content;

    private EnumState enumState;

    private String description;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
