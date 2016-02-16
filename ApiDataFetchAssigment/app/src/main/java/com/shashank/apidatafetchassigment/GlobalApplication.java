package com.shashank.apidatafetchassigment;

import android.app.Application;
import android.graphics.Bitmap;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.shashank.apidatafetchassigment.utils.ImageHelper;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

/**
 * Created by sha2nkk on 17/02/16.
 */
public class GlobalApplication extends Application {

    RequestQueue mRequestQueue;
    private static Application mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        //Create new Volley Request Queue
        mRequestQueue = Volley.newRequestQueue(this);

        //Init Image Helper
        new ImageHelper(this);
    }

    public Application getInstance() {
        return mInstance;
    }

}
