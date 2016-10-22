package com.jassdev.jackson.cyberplattestapp.model;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jassdev.jackson.cyberplattestapp.databinding.CardBinding;

public class FeedViewHolder extends RecyclerView.ViewHolder {

    private CardBinding b;

    private ImageView cardImageView;
    private CardView cardView;
    private TextView siteUrlTextView;
    private TextView cardDescriptionTextView;
    private TextView cardTitleTextView;

    public FeedViewHolder(View holderView) {
        super(holderView);
        b = DataBindingUtil.bind(itemView);

        cardView = b.cardView;
        cardImageView = b.feedCardImage;
        siteUrlTextView = b.feedCardSiteUrl;
        cardTitleTextView = b.feedCardTitle;
        cardDescriptionTextView = b.feedCardDescription;
    }

    public TextView getCardDescriptionTextView() {
        return cardDescriptionTextView;
    }

    public TextView getCardTitleTextView() {
        return cardTitleTextView;
    }

    public TextView getSiteUrlTextView() {
        return siteUrlTextView;
    }

    public CardView getCardView() {
        return cardView;
    }

    public ImageView getCardImageView() {
        return cardImageView;
    }
}