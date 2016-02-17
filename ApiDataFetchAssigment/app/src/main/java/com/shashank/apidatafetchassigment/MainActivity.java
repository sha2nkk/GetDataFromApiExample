package com.shashank.apidatafetchassigment;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;

import com.android.volley.Request;
import com.shashank.apidatafetchassigment.adapters.RecyclerViewAdapter;
import com.shashank.apidatafetchassigment.api.ApiClient;
import com.shashank.apidatafetchassigment.common.SpacingItemDecoration;
import com.shashank.apidatafetchassigment.databinding.MainActivityBinding;
import com.shashank.apidatafetchassigment.models.Data;
import java.util.List;

/**
 * Created by sha2nkk on 16/02/16.
 */
public class MainActivity extends BaseActivity {

    MainActivityBinding mBinding;
    ApiClient mClient;

    @Override
    protected void setBindings() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        setSupportActionBar(mBinding.toolbar);
        mClient= new ApiClient(GlobalApplication.getInstance().getRequestQueue(),"getData",Request.Method.GET);
        callApi();

    }

    public void retryConnection(View v) {
        if(mClient.getStatus() == ApiClient.Status.NOT_RUNNING) {
            callApi();
        }
    }


    public void callApi() {
//        mBinding.rvData.setVisibility(View.GONE);
//        mBinding.relNoNetwork.setVisibility(View.GONE);
//        mBinding.prgCoursesLoader.setVisibility(View.VISIBLE);
        mClient.setListener(new ApiClient.onResponse() {
            @Override
            public void onSuccess(List<Data> data) {
                mBinding.rvData.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                mBinding.rvData.addItemDecoration(new SpacingItemDecoration(getResources().getDimension(R.dimen.card_left_spacing), getResources().getDimension(R.dimen.card_top_spacing), getResources().getDimension(R.dimen.card_right_spacing), getResources().getDimension(R.dimen.card_bottom_spacing)));
                mBinding.rvData.setAdapter(new RecyclerViewAdapter(data));
                //on Success Hide Error Layout and Progress
//                mBinding.rvData.setVisibility(View.VISIBLE);
//                mBinding.relNoNetwork.setVisibility(View.GONE);
//                mBinding.prgCoursesLoader.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(int ErrorCode, String msg) {
                //On Failure Hide RecyclerView
//                mBinding.rvData.setVisibility(View.GONE);
//                mBinding.relNoNetwork.setVisibility(View.VISIBLE);
//                mBinding.prgCoursesLoader.setVisibility(View.GONE);
            }
        });
        mClient.call();
    }

    @Override
    public void onNoInternet() {

    }


}
