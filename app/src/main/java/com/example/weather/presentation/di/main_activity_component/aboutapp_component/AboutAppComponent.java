package com.example.weather.presentation.di.main_activity_component.aboutapp_component;

import com.example.weather.presentation.main.aboutapp_screen.AboutAppFragment;

import dagger.Subcomponent;

@Subcomponent(modules = AboutAppModule.class)
@AboutAppScope
public interface AboutAppComponent {
    void inject(AboutAppFragment aboutAppFragment);
}
