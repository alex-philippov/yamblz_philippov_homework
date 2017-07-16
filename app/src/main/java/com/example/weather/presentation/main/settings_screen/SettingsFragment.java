package com.example.weather.presentation.main.settings_screen;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weather.R;
import com.example.weather.WeatherApp;
import com.example.weather.presentation.PreferenceManager;
import com.example.weather.presentation.common.BasePresenter;
import com.example.weather.presentation.main.common.BaseMainFragment;

import java.util.Set;

import javax.inject.Inject;


public class SettingsFragment extends PreferenceFragmentCompat
        implements SharedPreferences.OnSharedPreferenceChangeListener{

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }
    @Inject
    PreferenceManager preferenceManager;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.settings);

    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Preference preference = findPreference(s);
        if (preference instanceof ListPreference) {
            ListPreference listPreference = (ListPreference) preference;
            int prefIndex = listPreference.findIndexOfValue(sharedPreferences.getString(s, ""));
            if (prefIndex >= 0) {
                int pereodic = Integer.parseInt(listPreference.getEntryValues()[prefIndex].toString());
                preference.setSummary(listPreference.getEntries()[prefIndex]);
                preferenceManager.setPereodic(pereodic);
            }
        } else {
            preference.setSummary(sharedPreferences.getString(s, ""));
        }

    }
}
