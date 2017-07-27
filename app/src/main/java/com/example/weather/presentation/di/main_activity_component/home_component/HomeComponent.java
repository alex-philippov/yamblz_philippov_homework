package com.example.weather.presentation.di.main_activity_component.home_component;

import com.example.weather.presentation.main.home_screen.HomeFragment;
import com.example.weather.presentation.main.home_screen.HomePresenter;

import dagger.Subcomponent;

@Subcomponent(modules = HomeModule.class)
@HomeScope
public interface HomeComponent {
    void inject(HomeFragment homeFragment);
    void inject(HomePresenter homePresenter);
}
