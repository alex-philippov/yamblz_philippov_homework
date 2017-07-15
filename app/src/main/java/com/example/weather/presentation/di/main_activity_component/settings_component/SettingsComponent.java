package com.example.weather.presentation.di.main_activity_component.settings_component;

import com.example.weather.presentation.main.settings_screen.SettingsFragment;

import dagger.Subcomponent;

@Subcomponent(modules = SettingsModule.class)
@SettingsScope
public interface SettingsComponent {
    void inject(SettingsFragment settingsFragment);
}
