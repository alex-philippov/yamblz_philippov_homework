package com.example.weather.presentation.di;

import com.example.weather.data.WeatherProvider;
import com.example.weather.domain.GetCurrentWeatherInteractor;
import com.example.weather.domain.GetCurrentWeatherInteractorImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DomainModule {

    @Provides
    @Singleton
    GetCurrentWeatherInteractor provideGetCurrentWeatherInteractor(WeatherProvider weatherProvider) {
        return new GetCurrentWeatherInteractorImpl(weatherProvider);
    }
}
