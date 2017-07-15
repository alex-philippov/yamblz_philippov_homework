package com.example.weather.presentation.di.main_activity_component;

import com.example.weather.presentation.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    @Provides
    @MainActivityScope
    MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }
}
