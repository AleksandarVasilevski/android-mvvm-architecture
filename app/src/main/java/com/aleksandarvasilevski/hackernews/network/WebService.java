package com.aleksandarvasilevski.hackernews.network;

import com.aleksandarvasilevski.hackernews.vo.Article;
import com.aleksandarvasilevski.hackernews.vo.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface WebService {

    @Headers("Content-Type: application/json")
    @GET("everything?sources=hacker-news&apiKey=baaadebdb03d42b59a8e43a825801b4f")
    Call<News> getNews();
}
