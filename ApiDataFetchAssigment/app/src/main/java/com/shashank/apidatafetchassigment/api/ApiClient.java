package com.shashank.apidatafetchassigment.api;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;

import com.activeandroid.query.Select;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shashank.apidatafetchassigment.models.Data;
import com.shashank.apidatafetchassigment.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sha2nkk on 17/02/16.
 */
public class ApiClient {

    //Specifies Status of APi
    public enum Status {
        RUNNING, NOT_RUNNING
    }

    public static final String BASE_URL = "private-21c80-care24androidtest.apiary-mock.com";
    public static final int NO_INTERNET = 0;
    private Status mStatus;
    private String mFeature;
    private RequestQueue mRequestQueue;
    private int mMethod;
    private onResponse mResponseListener;
    private List<Pair<String,Object>> mParams;

    public ApiClient(RequestQueue requestQueue, String feature, int type) {
        mRequestQueue = requestQueue;
        mFeature = feature;
        mMethod = type;
        mStatus = Status.NOT_RUNNING;
    }

    public void setListener(onResponse response) {
        mResponseListener = response;
    }

    public void setParams(List<Pair<String,Object>> params) {
        mParams = params;
    }

    public String buildUrl() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http").authority(BASE_URL).appendPath("androidtest").appendPath(mFeature);

        if(mParams != null && !mParams.isEmpty()) {
            for (Pair<String, Object> pair : mParams) {
                builder.appendQueryParameter(pair.first, pair.second.toString());
            }
        }
        return builder.build().toString();
    }


    public void call() {
        mStatus = Status.RUNNING;
        //Fetch only if data is not Present
        if(new Select().from(Data.class).count() == 0) {
            //If Internet no available show error
            if(Utils.isNetworkAvailable()) {
                JsonObjectRequest request = new JsonObjectRequest(mMethod, buildUrl(), "", new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray dataArray = response.getJSONArray("data");
                            List<Data> data = new Gson().fromJson(dataArray.toString(), new TypeToken<List<Data>>() {
                            }.getType());
                            data = filterEmptyItemsandSavetoDB(data);
                            if (mResponseListener != null) {
                                mResponseListener.onSuccess(data);
                            }
                            mStatus = Status.NOT_RUNNING;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            mResponseListener.onFailure(0,"No Internet");
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (mResponseListener != null) {
                            mResponseListener.onFailure(error.networkResponse.statusCode, error.getMessage());
                        }
                        mStatus = Status.NOT_RUNNING;
                    }
                });

                mRequestQueue.add(request);
            }
            else {
                mResponseListener.onFailure(0,"No Internet");
            }
        } else {

            List<Data> data= new Select().from(Data.class).execute();
            mResponseListener.onSuccess(data);
        }
    }

    public List<Data> filterEmptyItemsandSavetoDB(List<Data> dataList) {

        List<Data> finalList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {

        }

        for (Data data : dataList) {
            if(!TextUtils.isEmpty(data.title)) {
                finalList.add(data);
                data.save();
            }
        }

        return  finalList;
    }

    public Status getStatus() {
        return mStatus;
    }


    public interface onResponse{
        public void onSuccess(List<Data> data);
        public void onFailure(int ErrorCode, String msg);
    }


}
