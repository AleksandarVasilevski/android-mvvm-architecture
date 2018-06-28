package com.aleksandarvasilevski.hackernews.di;

import com.aleksandarvasilevski.hackernews.ui.MainActivity;

import dagger.Component;

@Component(modules = {RepositoryModule.class, ViewModelFactoryModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
}
