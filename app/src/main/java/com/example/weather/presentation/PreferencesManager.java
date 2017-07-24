package com.example.weather.presentation;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferencesManager {

    private final String UPDATE_INTERVAL = "b_interval";
    private final String FIRST_TIME_USE = "b_first_time_user";

    private SharedPreferences sharedPreferences;

    public PreferencesManager(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getCurrentUpdateInterval() {
        return sharedPreferences.getString(UPDATE_INTERVAL, "3600000");
    }

    public boolean getFirstTimeUser() {
        return sharedPreferences.getBoolean(FIRST_TIME_USE, true);
    }

    public void setFirstTimeUser(boolean status) {
        sharedPreferences.edit().putBoolean(FIRST_TIME_USE, status).apply();
    }
}
