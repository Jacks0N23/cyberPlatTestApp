package com.jassdev.jackson.cyberplattestapp.di;

import com.jassdev.jackson.cyberplattestapp.model.FeedItem;

import dagger.Module;
import dagger.Provides;


@Module
public class FeedItemsModule {
    private FeedItem item;

    @Provides
    public FeedItem provideModel() {
        item = new FeedItem();
        item.setTitle("АБракодабра");
        item.setDescription("wfjkncwejkbcwkjebvwejvb;jabv dsmnq oeu");
        item.setImgUrl("https://icdn.lenta.ru/assets/webpack/images/04ceff52e5b673154a365683e768578e.lenta_og.png");
        item.setUrl("https://lenta.ru/news/2016/10/23/martirosyan/");
        return item;
    }
}
