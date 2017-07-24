package com.example.weather.presentation.main.settings_screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weather.R;
import com.example.weather.WeatherApp;
import com.example.weather.presentation.PreferencesManager;
import com.example.weather.presentation.android_job.WeatherJob;
import com.yarolegovich.mp.MaterialChoicePreference;
import com.yarolegovich.mp.MaterialSwitchPreference;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class SettingsFragment extends Fragment {

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @BindView(R.id.updateSwitchPreference)
    MaterialSwitchPreference switchPreference;

    @BindView(R.id.updateIntervalPreference)
    MaterialChoicePreference choicePreference;

    @Inject
    PreferencesManager preferencesManager;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        WeatherApp.getInstance().plusMainActivityComponent().inject(this);
        unbinder = ButterKnife.bind(this, view);
        setChoicePreferenceStatus(switchPreference.getValue());

        switchPreference.setOnClickListener(v -> {
            if (switchPreference.getValue()) {
                long interval = Long.valueOf(preferencesManager.getCurrentUpdateInterval());
                WeatherJob.scheduleJob(interval);
            } else {
                WeatherJob.stopJob();
            }
            setChoicePreferenceStatus(switchPreference.getValue());
        });
    }

    private void setChoicePreferenceStatus(boolean updateSwitchValue) {
        if (updateSwitchValue) {
            choicePreference.setEnabled(false);
        } else {
            choicePreference.setEnabled(true);
        }
    }
}
