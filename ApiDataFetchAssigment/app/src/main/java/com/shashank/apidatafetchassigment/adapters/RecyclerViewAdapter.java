package com.shashank.apidatafetchassigment.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shashank.apidatafetchassigment.BR;
import com.shashank.apidatafetchassigment.R;
import com.shashank.apidatafetchassigment.models.Data;

import java.util.List;

/**
 * Created by sha2nkk on 17/02/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<CommonViewHolder> {

    private  List<Data> mDataList;

    public RecyclerViewAdapter(List<Data> dataList) {
        mDataList = dataList;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_data, parent);
        return new CommonViewHolder(root);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.model, mDataList.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
