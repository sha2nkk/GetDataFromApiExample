package com.shashank.apidatafetchassigment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sha2nkk on 17/02/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBindings();
    }

    protected abstract void setBindings();

    public abstract void onNoInternet();
}
