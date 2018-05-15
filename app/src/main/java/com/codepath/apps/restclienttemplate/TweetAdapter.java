package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder> {

    private List<Tweet> tweets;
    private Context mContext;

    public TweetAdapter(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_tweet, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tweet tweet = tweets.get(position);
        holder.tvUsername.setText(tweet.user.name);
        holder.tvBody.setText(tweet.body);
        Glide.with(mContext)
                .load(tweet.user.profileImageUrl)
                .into(holder.ivProfileImage);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivProfileImage;
        public TextView tvUsername;
        public TextView tvBody;

        public ViewHolder(View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvUsername = itemView.findViewById(R.id.tvUserName);
            tvBody = itemView.findViewById(R.id.tvBody);
        }

    }

}
