package com.example.weather.presentation.main.home_screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weather.R;
import com.example.weather.WeatherApp;
import com.example.weather.presentation.common.BasePresenter;
import com.example.weather.presentation.main.common.BaseMainFragment;

import javax.inject.Inject;

public class HomeFragment extends BaseMainFragment implements HomeView {
    public static final String TAG = "tag_home_fragment";

    @Inject
    HomePresenter homePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void showLoad() {

    }

    @Override
    public void hideLoad() {

    }

    @Override
    public String getTitle() {
        return getString(R.string.app_name);
    }

    @Override
    protected BasePresenter getPresenter() {
        return homePresenter;
    }

    @Override
    protected void inject() {
        WeatherApp.getInstance().plusHomeComponent().inject(this);
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void showWeather(HomeViewModel homeViewModel) {
        Log.i(TAG, "showWeather: " + homeViewModel.toString());
    }
}
