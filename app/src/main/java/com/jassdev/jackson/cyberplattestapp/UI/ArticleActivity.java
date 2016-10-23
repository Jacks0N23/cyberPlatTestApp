package com.jassdev.jackson.cyberplattestapp.UI;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jassdev.jackson.cyberplattestapp.R;
import com.jassdev.jackson.cyberplattestapp.Utils.Constants;
import com.jassdev.jackson.cyberplattestapp.databinding.ArticleBinding;
import com.jassdev.jackson.cyberplattestapp.loadingArticle.ArticlePresenterImpl;
import com.jassdev.jackson.cyberplattestapp.loadingArticle.IArticleView;

public class ArticleActivity extends BaseActivity implements IArticleView {

    ArticleBinding binding;
    ArticlePresenterImpl presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.article);
        setTitle("Статья");

        presenter = new ArticlePresenterImpl(this, this);
        presenter.loadWebView(getIntent().getStringExtra(Constants.EXTRA_ARTICLE_URL));
    }

    @Override
    public void loadWebView(String url) {
        binding.article.setWebViewClient(new ArticleWebViewClient());
        binding.article.loadUrl(url);
    }

    //нужно чтоббы не перекидывало в хром, а открывалось в приложении
    private class ArticleWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }
}
