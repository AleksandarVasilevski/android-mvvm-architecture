package com.aleksandarvasilevski.hackernews.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestService {

    private static final String URL =
            "https://newsapi.org/v2/";

    private WebService webService;

    public RestService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        webService = retrofit.create(WebService.class);
    }

    public WebService getWebService(){
        return webService;
    }
}
