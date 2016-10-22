package com.jassdev.jackson.cyberplattestapp.model;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jassdev.jackson.cyberplattestapp.R;
import com.jassdev.jackson.cyberplattestapp.UI.ArticleActivity;
import com.jassdev.jackson.cyberplattestapp.Utils.Constants;

import java.util.ArrayList;


public class FeedRecyclerViewAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    private final String TAG = FeedRecyclerViewAdapter.class.getSimpleName();
    private Activity activity;
    private ArrayList<FeedItem> feedItemArrayList;


    public FeedRecyclerViewAdapter(ArrayList<FeedItem> feedItemArrayList, Activity activity) {
        this.feedItemArrayList = feedItemArrayList;
        this.activity = activity;
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new FeedViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FeedViewHolder holder, int position) {

        final FeedItem feedItem = feedItemArrayList.get(position);
        holder.getCardTitleTextView().setText(feedItem.getTitle());
        holder.getCardDescriptionTextView().setText(feedItem.getDescription());
        holder.getSiteUrlTextView().setText(feedItem.getUrl());

        Glide.with(activity).load(feedItem.getImgUrl()).into(holder.getCardImageView());


        final String url = feedItem.getUrl();

        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent articleIntent = new Intent(activity, ArticleActivity.class);
                articleIntent.putExtra(Constants.EXTRA_ARTICLE_URL, url);
                activity.startActivity(articleIntent);
            }
        });

        holder.getCardView().setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                Log.d(TAG, "onLingClick cardview");
                ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData copyLink = ClipData.newPlainText("", feedItem.getUrl());
                clipboardManager.setPrimaryClip(copyLink);
                Toast.makeText(view.getContext(), R.string.main, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return feedItemArrayList.size();
    }
}
