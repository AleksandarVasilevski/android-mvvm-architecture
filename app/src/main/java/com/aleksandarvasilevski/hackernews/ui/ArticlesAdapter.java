package com.aleksandarvasilevski.hackernews.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aleksandarvasilevski.hackernews.R;
import com.aleksandarvasilevski.hackernews.vo.Article;

import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {

    private List<Article> articles;

    public ArticlesAdapter(List<Article> articles){
        this.articles = articles;
    }

    @NonNull
    @Override
    public ArticlesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesAdapter.ViewHolder holder, int position) {
        holder.authorTextView.setText(articles.get(position).getAuthor());
        holder.titleTextView.setText(articles.get(position).getTitle());
        holder.timeTextView.setText(String.valueOf(articles.get(position).getPublishedAt()));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView authorTextView;
        TextView titleTextView;
        TextView timeTextView;
        ViewHolder(View viewItem){
            super(viewItem);
            authorTextView = viewItem.findViewById(R.id.item_news_author);
            titleTextView = viewItem.findViewById(R.id.item_news_title);
            timeTextView = viewItem.findViewById(R.id.item_news_time);
        }
    }
}
