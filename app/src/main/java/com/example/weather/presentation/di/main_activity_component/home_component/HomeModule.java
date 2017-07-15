package com.example.weather.presentation.di.main_activity_component.home_component;

import com.example.weather.presentation.main.home_screen.HomePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {
    @Provides
    @HomeScope
    public HomePresenter provideHomePresenter() {
        return new HomePresenter();
    }
}
