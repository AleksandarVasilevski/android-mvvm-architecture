package com.aleksandarvasilevski.hackernews.di;

import com.aleksandarvasilevski.hackernews.repository.MainRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    //Provides MainRepository
    @Provides
    MainRepository provideMainRepository(){
        return new MainRepository();
    }
}
