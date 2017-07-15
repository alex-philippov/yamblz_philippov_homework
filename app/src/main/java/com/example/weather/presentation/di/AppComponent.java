package com.example.weather.presentation.di;

import com.example.weather.presentation.di.main_activity_component.MainActivityComponent;
import com.example.weather.presentation.di.main_activity_component.WeatherModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, DataModule.class, DomainModule.class})
@Singleton
public interface AppComponent {
    MainActivityComponent plusMainActivityComponent(WeatherModule weatherModule);
}
