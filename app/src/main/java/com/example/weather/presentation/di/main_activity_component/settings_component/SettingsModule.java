package com.example.weather.presentation.di.main_activity_component.settings_component;

import com.example.weather.presentation.main.settings_screen.SettingsPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingsModule {
    @Provides
    @SettingsScope
    public SettingsPresenter provideSettingsPresenter() {
        return new SettingsPresenter();
    }
}
