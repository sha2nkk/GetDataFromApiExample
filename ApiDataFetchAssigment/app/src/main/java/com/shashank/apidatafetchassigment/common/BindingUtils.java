package com.shashank.apidatafetchassigment.common;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.shashank.apidatafetchassigment.utils.ImageHelper;

/**
 * Created by sha2nkk on 17/02/16.
 */
public class BindingUtils {

    @BindingAdapter({"defaultImage", "imageUrl"})
    public static void bindImageUrl(ImageView imageView, Drawable defaultImage, String imageUrl) {
            ImageHelper.loadImage(imageView,imageUrl,defaultImage, Bitmap.Config.RGB_565);
    }
}
