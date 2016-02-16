package com.shashank.apidatafetchassigment.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/**
 * Created by sha2nkk on 17/02/16.
 */
public class CommonViewHolder extends RecyclerView.ViewHolder{

    ViewDataBinding mBinding;

    public CommonViewHolder(View itemView) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
    }

    public ViewDataBinding getBinding() {
        return mBinding;
    }


}
