package com.aleksandarvasilevski.hackernews.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.aleksandarvasilevski.hackernews.repository.MainRepository;
import com.aleksandarvasilevski.hackernews.vo.News;

public class MainViewModel extends ViewModel {

    private MainRepository mainRepository;
    private LiveData<News> news;

    public MainViewModel(MainRepository mainRepository){
        this.mainRepository = mainRepository;
    }

    public void init(){
        if (news == null){
            news = mainRepository.getNews();
        }
    }

    public LiveData<News> getNews(){
        return news;
    }
}
