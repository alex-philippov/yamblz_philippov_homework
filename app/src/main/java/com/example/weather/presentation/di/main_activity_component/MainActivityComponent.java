package com.example.weather.presentation.di.main_activity_component;

import com.example.weather.presentation.di.main_activity_component.aboutapp_component.AboutAppComponent;
import com.example.weather.presentation.di.main_activity_component.aboutapp_component.AboutAppModule;
import com.example.weather.presentation.di.main_activity_component.home_component.HomeComponent;
import com.example.weather.presentation.di.main_activity_component.home_component.HomeModule;
import com.example.weather.presentation.main.MainActivity;
import com.example.weather.presentation.main.settings_screen.SettingsFragment;

import dagger.Subcomponent;

@Subcomponent(modules = { WeatherModule.class, MainActivityModule.class })
@MainActivityScope
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
    void inject(SettingsFragment settingsFragment);

    HomeComponent plusHomeComponent(HomeModule homeModule);
    AboutAppComponent plusAboutAppComponent(AboutAppModule aboutAppModule);
}
