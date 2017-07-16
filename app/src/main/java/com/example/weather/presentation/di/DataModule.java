package com.example.weather.presentation.di;

import com.example.weather.data.OpenWeatherProvider;
import com.example.weather.data.WeatherApi;
import com.example.weather.data.WeatherProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    @Provides
    @Singleton
    WeatherProvider provideWeatherProvider(WeatherApi weatherApi) {
        return new OpenWeatherProvider(weatherApi);
    }

    @Provides
    @Singleton
    WeatherApi provideWeatherApi() {
        return new Retrofit.Builder()
                .baseUrl(WeatherApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(WeatherApi.class);
    }
}
