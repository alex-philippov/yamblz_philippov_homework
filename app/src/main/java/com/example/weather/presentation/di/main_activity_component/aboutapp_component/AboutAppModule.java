package com.example.weather.presentation.di.main_activity_component.aboutapp_component;

import com.example.weather.presentation.main.aboutapp_screen.AboutAppFragment;
import com.example.weather.presentation.main.aboutapp_screen.AboutAppPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class AboutAppModule {

    @Provides
    @AboutAppScope
    public AboutAppPresenter provideAboutAppPresenter() {
        return new AboutAppPresenter();
    }
}
