package com.jassdev.jackson.cyberplattestapp.loadingArticle;

import com.jassdev.jackson.cyberplattestapp.UI.BaseActivity;

/**
 * Created by Jackson on 22/10/2016.
 */

public class ArticlePresenterImpl implements IArticlePresenter {

    /**
     * тут можно было бы сделать всё через ещё один парсер для статей, но я делал уже похожий для ленты
     * и ещё раз делать не хочется, ведь смысл примерно такой же
     */

    private IArticleView view;
    private BaseActivity baseActivity;

    public ArticlePresenterImpl(IArticleView view, BaseActivity baseActivity) {
        this.view = view;
        this.baseActivity = baseActivity;
    }

    @Override
    public void loadWebView(String url) {
        if (baseActivity.checkInternetConnection())
            view.loadWebView(url);
        else
            baseActivity.noInternetConnection();
    }

}
