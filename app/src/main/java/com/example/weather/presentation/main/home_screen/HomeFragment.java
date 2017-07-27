package com.example.weather.presentation.main.home_screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.TextViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather.R;
import com.example.weather.WeatherApp;
import com.example.weather.presentation.common.BasePresenter;
import com.example.weather.presentation.main.common.BaseMainFragment;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class HomeFragment extends BaseMainFragment implements HomeView {
    public static final String TAG = "tag_home_fragment";
    private TextView tvTemperature;
    private TextView tvCity;
    private TextView tvWeather;
    private TextView tvWind;
    private ImageView ivIcon;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Inject
    HomePresenter homePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCity = view.findViewById(R.id.tv_city);
        tvTemperature = view.findViewById(R.id.tv_temperature);
        tvWeather = view.findViewById(R.id.tv_weather);
        tvWind = view.findViewById(R.id.tv_wind);
        ivIcon = view.findViewById(R.id.iv_icon);
        swipeRefreshLayout = view.findViewById(R.id.swipe_container);
        swipeRefreshLayout.setOnRefreshListener(() ->
                ((HomePresenter)getPresenter()).refreshweather());
    }

    @Override
    public void showLoad() {
        //TODO
    }

    @Override
    public void hideLoad() {
        //TODO
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
        tvCity.setText(homeViewModel.getCity());
        tvTemperature.setText(homeViewModel.getTemperature());
        tvWeather.setText(homeViewModel.getMain());
        tvWind.setText(homeViewModel.getWind());
        Picasso.with(getContext()).load(homeViewModel.getIconId()).into(ivIcon);
        Log.i(TAG, "showWeather: " + homeViewModel.toString());
    }

    @Override
    public void onGetWeather() {
        swipeRefreshLayout.setRefreshing(false);
    }
}
