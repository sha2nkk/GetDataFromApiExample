package com.shashank.apidatafetchassigment;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;

import com.shashank.apidatafetchassigment.adapters.RecyclerViewAdapter;
import com.shashank.apidatafetchassigment.common.SpacingItemDecoration;
import com.shashank.apidatafetchassigment.databinding.MainActivityBinding;
import com.shashank.apidatafetchassigment.models.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sha2nkk on 16/02/16.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void setBindings() {
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        setSupportActionBar(binding.toolbar);
        List<Data> data = new ArrayList<>();
        data.add(new Data(1,"http://cache4.asset-cache.net/xt/597308825.jpg?v=1&g=fs1|0|EYM|08|825&s=1&b=RjI4","Close-Up Of Insect Pollinating On Pink Flower"));
        data.add(new Data(2,"http://cache2.asset-cache.net/xt/487272630.jpg?v=1&g=fs2|0|editorial212|72|630&s=1&b=Ng==","Woman riding on an Elephant, Tropical Rain Forest"));
        data.add(new Data(2,"http://cache2.asset-cache.net/xt/487272630.jpg?v=1&g=fs2|0|editorial212|72|630&s=1&b=Ng==","Woman riding on an Elephant, Tropical Rain Forest"));
        data.add(new Data(2,"http://cache2.asset-cache.net/xt/487272630.jpg?v=1&g=fs2|0|editorial212|72|630&s=1&b=Ng==","Woman riding on an Elephant, Tropical Rain Forest"));
        data.add(new Data(2,"http://cache2.asset-cache.net/xt/487272630.jpg?v=1&g=fs2|0|editorial212|72|630&s=1&b=Ng==","Woman riding on an Elephant, Tropical Rain Forest"));
        data.add(new Data(2,"asds","Woman riding on an Elephant, Tropical Rain Forest"));
        binding.rvData.setAdapter(new RecyclerViewAdapter(data));
        binding.rvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.rvData.addItemDecoration(new SpacingItemDecoration(getResources().getDimension(R.dimen.card_left_spacing),getResources().getDimension(R.dimen.card_top_spacing),getResources().getDimension(R.dimen.card_right_spacing),getResources().getDimension(R.dimen.card_bottom_spacing)));
    }

    @Override
    public void onNoInternet() {

    }
}
