package com.jassdev.jackson.cyberplattestapp.UI;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.jassdev.jackson.cyberplattestapp.R;
import com.jassdev.jackson.cyberplattestapp.databinding.ActivityMainBinding;
import com.jassdev.jackson.cyberplattestapp.loadingFeed.FeedPresenterImpl;
import com.jassdev.jackson.cyberplattestapp.loadingFeed.IFeedView;
import com.jassdev.jackson.cyberplattestapp.model.FeedItem;
import com.jassdev.jackson.cyberplattestapp.model.FeedRecyclerViewAdapter;

import java.util.ArrayList;

public class FeedActivity extends BaseActivity implements IFeedView, SwipeRefreshLayout.OnRefreshListener {

    ActivityMainBinding binding;
    FeedPresenterImpl presenter;
    FeedItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        presenter = new FeedPresenterImpl(this, this); //first this is IFeedView, Second is BaseActivity

        /**
         * uncomment for DI
         AppComponent component = DaggerTestApp.component(this);
         component.inject(this);

         item = component.testsItems();

         **/

        binding.feedSwipeRefresh.setOnRefreshListener(this);
        binding.feedSwipeRefresh.setRefreshing(true);
        presenter.loadData();
    }


    @Override
    public void onFeedLoadedSuccess(ArrayList<FeedItem> list) {
        binding.feedSwipeRefresh.setRefreshing(false);
        binding.feedRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.feedRecyclerView.setHasFixedSize(true);
        binding.feedRecyclerView.setAdapter(new FeedRecyclerViewAdapter(list, this));
        /**
         * uncomment for DI
         binding.feedRecyclerView.setAdapter(new FeedRecyclerViewAdapter(Collections.singletonList(item), this));
         **/

    }

    @Override
    public void onRefresh() {
        binding.feedSwipeRefresh.setRefreshing(true);
        presenter.loadData();
    }
}
