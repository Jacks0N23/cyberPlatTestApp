package com.jassdev.jackson.cyberplattestapp.loadingFeed;

import com.jassdev.jackson.cyberplattestapp.UI.BaseActivity;
import com.jassdev.jackson.cyberplattestapp.Utils.Constants;
import com.jassdev.jackson.cyberplattestapp.model.FeedItem;

import java.util.ArrayList;


public class FeedPresenterImpl implements IFeedPresenter, OnLoadingInteractorFinishedListener {

    private static final String TAG = "LoadingPresenterImpl";
    private IFeedView view;
    private BaseActivity baseActivity;

    public FeedPresenterImpl(IFeedView view, BaseActivity baseActivity) {
        this.view = view;
        this.baseActivity = baseActivity;
    }

    @Override
    public void loadData() {
        if (baseActivity.checkInternetConnection())
            new FeedParser(this).execute(Constants.RSS_URL);
        else
            onNetworkFailure();
    }

    @Override
    public void OnCompleted(ArrayList<FeedItem> list) {
        view.onFeedLoadedSuccess(list);
    }

    @Override
    public void onNetworkFailure() {
        baseActivity.noInternetConnection();
    }

}
