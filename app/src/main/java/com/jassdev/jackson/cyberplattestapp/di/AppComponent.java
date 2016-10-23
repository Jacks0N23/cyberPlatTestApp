package com.jassdev.jackson.cyberplattestapp.di;

import com.jassdev.jackson.cyberplattestapp.UI.FeedActivity;
import com.jassdev.jackson.cyberplattestapp.model.FeedItem;

import dagger.Component;

@Component(modules = {FeedItemsModule.class})
public interface AppComponent {
    void inject(FeedActivity feedActivity);
    FeedItem testsItems();
}
