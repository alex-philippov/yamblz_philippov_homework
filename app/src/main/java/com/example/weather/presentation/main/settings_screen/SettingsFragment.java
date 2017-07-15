package com.example.weather.presentation.main.settings_screen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weather.R;
import com.example.weather.WeatherApp;
import com.example.weather.presentation.common.BasePresenter;
import com.example.weather.presentation.main.common.BaseMainFragment;

import java.util.Set;

import javax.inject.Inject;


public class SettingsFragment extends BaseMainFragment implements SettingsView {
    @Inject
    SettingsPresenter settingsPresenter;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void showLoad() {

    }

    @Override
    public void hideLoad() {

    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    protected BasePresenter getPresenter() {
        return settingsPresenter;
    }

    @Override
    protected void inject() {
        WeatherApp.getInstance().plusSettingsComponent().inject(this);
    }
}
