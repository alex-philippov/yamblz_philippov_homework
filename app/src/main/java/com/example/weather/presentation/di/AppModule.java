package com.example.weather.presentation.di;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.weather.presentation.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;

    public AppModule(@NonNull Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    public PreferenceManager providePreferenceManager(Context context) {
        return new PreferenceManager(context);
    }
}
