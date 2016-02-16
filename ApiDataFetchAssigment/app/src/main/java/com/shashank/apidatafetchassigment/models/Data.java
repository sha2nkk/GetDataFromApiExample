package com.shashank.apidatafetchassigment.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sha2nkk on 17/02/16.
 */
public class Data {
    public long id;

    @SerializedName("uri")
    public String imageUrl;

    public String title;

    public Data(long id, String imageUrl, String title) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
    }
}
