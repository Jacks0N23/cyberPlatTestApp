package com.jassdev.jackson.cyberplattestapp.loadingFeed;

import android.os.AsyncTask;

import com.jassdev.jackson.cyberplattestapp.model.FeedItem;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class FeedParser extends AsyncTask<String, Void, Void> {


    private OnLoadingInteractorFinishedListener listener;

    private String wrongMes = "";
    private FeedItem feedItem;
    private ArrayList<FeedItem> mFeedItems = new ArrayList<>();

    public FeedParser(OnLoadingInteractorFinishedListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... params) {
        final Document[] document = new Document[1];
        document[0] = null;

        try {
            document[0] = Jsoup.connect(params[0]).timeout(30000).ignoreHttpErrors(true).get();
        } catch (IOException e) {
            e.printStackTrace();
            wrongMes = "Не получилось загрузить ещё статей\nПроверьте соединение и попробуйте перезайти в приложение";
        }
        if (document[0] != null) {
            Elements elements = document[0].select("item");
            for (Element element : elements) {
                feedItem = new FeedItem();
                feedItem.setTitle(element.select("title").text());
                feedItem.setDescription(element.select("description").text());
                feedItem.setUrl(element.select("link").text());
                feedItem.setImgUrl(element.getElementsByTag("enclosure").attr("url"));

                mFeedItems.add(feedItem);
            }
        }
        return null;
    }


    @Override
    protected void onPostExecute(final Void aVoid) {
        if (!wrongMes.equals(""))
            listener.onNetworkFailure();
        else
            listener.OnCompleted(mFeedItems);
    }
}
