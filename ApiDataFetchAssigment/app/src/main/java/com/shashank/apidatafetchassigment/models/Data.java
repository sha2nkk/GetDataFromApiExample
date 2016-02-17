package com.shashank.apidatafetchassigment.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sha2nkk on 17/02/16.
 */
@Table(name = "Data")
public class Data extends Model{
    @Column(name = "mId")
    public Long id;

    @SerializedName("uri")
    @Column(name = "imageUrl")
    public String imageUrl;

    @Column(name = "title")
    public String title;

    public Data() {

    }

    public Data(long id, String imageUrl, String title) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
    }
}
