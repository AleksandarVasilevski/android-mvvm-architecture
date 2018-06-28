package com.aleksandarvasilevski.hackernews;

import android.app.Application;

import com.aleksandarvasilevski.hackernews.di.ApplicationComponent;
import com.aleksandarvasilevski.hackernews.di.DaggerApplicationComponent;
import com.aleksandarvasilevski.hackernews.di.RepositoryModule;
import com.aleksandarvasilevski.hackernews.di.ViewModelFactoryModule;

public class HackerNews extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .repositoryModule(new RepositoryModule())
                .viewModelFactoryModule(new ViewModelFactoryModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
