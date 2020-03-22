package web.client;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by firatulgay on 27.12.2019.
 */
public class ClientArizaDto {

    @SerializedName("id")
    private long id ;

    @SerializedName("adi")
    private String adi;

    @SerializedName("date")
    private Date date;

    @SerializedName("content")
    private String content;

    @SerializedName("enumState")
    private String enumState;

    @SerializedName("description")
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

    public String getEnumState() {
        return enumState;
    }

    public void setEnumState(String enumState) {
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
