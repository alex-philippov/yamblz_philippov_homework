package com.example.weather;

import android.app.Application;

import com.evernote.android.job.JobManager;
import com.example.weather.presentation.android_job.WeatherJob;
import com.example.weather.presentation.android_job.WeatherJobCreator;
import com.example.weather.presentation.di.AppComponent;
import com.example.weather.presentation.di.AppModule;
import com.example.weather.presentation.di.DaggerAppComponent;
import com.example.weather.presentation.di.main_activity_component.MainActivityComponent;
import com.example.weather.presentation.di.main_activity_component.WeatherModule;
import com.example.weather.presentation.di.main_activity_component.aboutapp_component.AboutAppComponent;
import com.example.weather.presentation.di.main_activity_component.aboutapp_component.AboutAppModule;
import com.example.weather.presentation.di.main_activity_component.home_component.HomeComponent;
import com.example.weather.presentation.di.main_activity_component.home_component.HomeModule;

public class WeatherApp extends Application {

    protected static WeatherApp instance;

    public static WeatherApp getInstance() {
        return instance;
    }

    private AppComponent appComponent;
    private MainActivityComponent mainActivityComponent;
    private HomeComponent homeComponent;
    private AboutAppComponent aboutAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        JobManager.create(this).addJobCreator(new WeatherJobCreator());
        WeatherJob.scheduleJob();
        instance = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .build();
    }

    public MainActivityComponent plusMainActivityComponent() {
        if (mainActivityComponent == null) {
            mainActivityComponent = appComponent.plusMainActivityComponent(new WeatherModule());
        }
        return mainActivityComponent;
    }

    public void clearMainActivityComponent() {
        mainActivityComponent = null;
    }

    public HomeComponent plusHomeComponent() {
        if (homeComponent == null) {
            homeComponent = mainActivityComponent.plusHomeComponent(new HomeModule());
        }
        return homeComponent;
    }

    public void clearHomeComponent() {
        homeComponent = null;
    }

    public AboutAppComponent plusAboutAppComponent() {
        if (aboutAppComponent == null) {
            aboutAppComponent = mainActivityComponent.plusAboutAppComponent(new AboutAppModule());
        }
        return aboutAppComponent;
    }
    public void clearAboutAppComponent() {
        aboutAppComponent = null;
    }

}
