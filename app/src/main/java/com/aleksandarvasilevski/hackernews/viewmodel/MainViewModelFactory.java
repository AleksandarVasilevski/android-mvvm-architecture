package com.aleksandarvasilevski.hackernews.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.aleksandarvasilevski.hackernews.repository.MainRepository;
import com.aleksandarvasilevski.hackernews.ui.MainViewModel;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private final MainRepository mainRepository;

    public MainViewModelFactory(MainRepository mainRepository){
        this.mainRepository = mainRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)){
            return (T) new MainViewModel(mainRepository);
        }else {
            throw new IllegalArgumentException("Unknown ViewModel Class");
        }
    }
}
