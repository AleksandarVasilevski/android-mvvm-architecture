package com.aleksandarvasilevski.hackernews.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.aleksandarvasilevski.hackernews.network.RestService;
import com.aleksandarvasilevski.hackernews.network.WebService;
import com.aleksandarvasilevski.hackernews.vo.News;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    private static final String LOG = "#LOG_MAINREPO";
    private WebService webService;

    public LiveData<News> getNews(){
        final MutableLiveData<News> newsLiveData = new MutableLiveData<>();

        webService = new RestService().getWebService();
        webService.getNews().enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                newsLiveData.setValue(response.body());
                Log.d("#LOG", response + " B");
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.d(LOG, "Retrofit response fail: " + t.getMessage());
            }
        });
        return newsLiveData;
    }
}
