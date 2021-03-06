package com.example.weather.presentation.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.weather.cache.CacheManager;
import com.example.weather.cache.PreferenceCacheManager;
import com.example.weather.data.OpenWeatherProvider;
import com.example.weather.data.WeatherApi;
import com.example.weather.data.WeatherProvider;
import com.example.weather.cache.PreferencesManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    @Provides
    CacheManager provideCacheManager(Context context) {
        return new PreferenceCacheManager(context);
    }

    @Provides
    @Singleton
    SharedPreferences provideDefaultSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    WeatherProvider provideWeatherProvider(WeatherApi weatherApi,
                                           CacheManager cacheManager,
                                           PreferencesManager preferencesManager) {
        return new OpenWeatherProvider(weatherApi, cacheManager, preferencesManager);
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
