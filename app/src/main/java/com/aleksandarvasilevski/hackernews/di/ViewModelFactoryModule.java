package com.aleksandarvasilevski.hackernews.di;

import android.arch.lifecycle.ViewModelProvider;

import com.aleksandarvasilevski.hackernews.repository.MainRepository;
import com.aleksandarvasilevski.hackernews.viewmodel.MainViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module(includes = RepositoryModule.class)
public class ViewModelFactoryModule {

    //Provides MainViewModelFactory
    @Provides
    ViewModelProvider.Factory provideMainViewModelFactory(MainRepository mainRepository){
        return new MainViewModelFactory(mainRepository);
    }
}
