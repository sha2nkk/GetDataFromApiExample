package com.shashank.apidatafetchassigment;

import android.databinding.DataBindingUtil;

import com.shashank.apidatafetchassigment.databinding.MainActivityBinding;

/**
 * Created by sha2nkk on 16/02/16.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void setBindings() {
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        setSupportActionBar(binding.toolbar);
    }

    @Override
    public void onNoInternet() {

    }
}
