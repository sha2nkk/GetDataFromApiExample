package com.shashank.apidatafetchassigment.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.shashank.apidatafetchassigment.R;
import com.squareup.picasso.Picasso;

/**
 * Created by sha2nkk on 17/02/16.
 */
public class ImageHelper {

    public static Picasso mPicassoInstance;

    public ImageHelper(Context context) {
        mPicassoInstance = Picasso.with(context);
    }

    public static void loadImage(ImageView imageView, String imageUrl) {
        loadImage(imageView,imageUrl, imageView.getContext().getResources().getDrawable(R.drawable.ic, imageView.getContext().getTheme()), Bitmap.Config.RGB_565);
    }

    public static void loadImage(ImageView imageView, String imageUrl,Drawable placeHolder,Bitmap.Config config) {
        mPicassoInstance.load(imageUrl)
                .config(config)
                .placeholder(placeHolder)
                .into(imageView);
    }
}
