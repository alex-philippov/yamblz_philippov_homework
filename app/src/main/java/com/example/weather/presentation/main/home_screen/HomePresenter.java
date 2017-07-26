package com.example.weather.presentation.main.home_screen;


import android.util.Log;

import com.example.weather.R;
import com.example.weather.WeatherApp;
import com.example.weather.domain.GetCurrentWeatherInteractor;
import com.example.weather.domain.entities.DetailedWeather;
import com.example.weather.presentation.main.common.BaseMainFragment;
import com.example.weather.presentation.main.common.BaseMainPresenter;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class HomePresenter extends BaseMainPresenter<HomeView> {
    public static final String TAG = "tag_home_presenter";

    @Inject
    GetCurrentWeatherInteractor getCurrentWeatherInteractor;

    public HomePresenter() {
        WeatherApp.getInstance().plusHomeComponent().inject(this);
    }

    @Override
    public void onAttach() {
        getWeather();
    }

    public void refreshweather() {
        getWeather();
    }

    private void getWeather() {
        getCurrentWeatherInteractor.execute(detailedWeather -> {
            getView().showWeather(HomeViewModel.create(detailedWeather));
            getView().onGetWeather();
        }, throwable -> {
            getView().showError(R.string.error);
            getView().onGetWeather();
            Log.i(TAG, "onAttach: " + throwable.toString());
        });
    }

    @Override
    public void onDetach() {

    }
}
