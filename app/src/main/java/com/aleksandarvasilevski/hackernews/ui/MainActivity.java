package com.aleksandarvasilevski.hackernews.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aleksandarvasilevski.hackernews.HackerNews;
import com.aleksandarvasilevski.hackernews.R;
import com.aleksandarvasilevski.hackernews.vo.Article;
import com.aleksandarvasilevski.hackernews.vo.News;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private MainViewModel mainViewModel;
    private ArticlesAdapter articlesAdapter;
    private LinearLayoutManager linearLayoutManager;
    @BindView(R.id.main_article_recycler_view) RecyclerView articleRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ButterKnife binding
        ButterKnife.bind(this);

        //Dagger2 dependency injection
        ((HackerNews) getApplication()).getApplicationComponent().inject(this);

        //Getting instance of ViewModel
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        mainViewModel.init();

        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        articleRecyclerView.setLayoutManager(linearLayoutManager);

        Observer<News> articleObserver = new Observer<News>() {
            @Override
            public void onChanged(@Nullable News news) {

                Article[] articles;
                articles = news.getArticles();

                List<Article> articleList = new ArrayList<>();
                for (Article article : articles) {
                    articleList.add(article);
                }

                articlesAdapter = new ArticlesAdapter(articleList);
                articleRecyclerView.setAdapter(articlesAdapter);
            }
        };
        mainViewModel.getNews().observe(this, articleObserver);
    }
}
