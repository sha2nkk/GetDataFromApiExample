package com.shashank.apidatafetchassigment.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.shashank.apidatafetchassigment.GlobalApplication;

/**
 * Created by Shashank K on 8/29/2015.
 */
public class Utils {
    //Returns whether internet is available
    public static Boolean isNetworkAvailable() {
        ConnectivityManager cm =
                (ConnectivityManager) GlobalApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();

    }
}
