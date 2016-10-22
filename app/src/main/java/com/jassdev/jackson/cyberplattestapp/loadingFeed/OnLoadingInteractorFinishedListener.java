package com.jassdev.jackson.cyberplattestapp.loadingFeed;

import com.jassdev.jackson.cyberplattestapp.model.FeedItem;

import java.util.ArrayList;

/**
 * Created by Jackson on 22/10/2016.
 */

public interface OnLoadingInteractorFinishedListener {
    void OnCompleted(ArrayList<FeedItem> list);
    void onNetworkFailure();
}
