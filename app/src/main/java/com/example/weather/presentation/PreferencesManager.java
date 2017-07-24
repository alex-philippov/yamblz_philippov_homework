package com.example.weather.presentation;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferencesManager {

    private final String BACKGROUND_SWITCH = "b_update";
    private final String UPDATE_INTERVAL = "b_interval";

    public static int pereodic = 900000;
    private SharedPreferences sharedPreferences;

    public PreferencesManager(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getCurrentUpdateInterval() {
        return sharedPreferences.getString(BACKGROUND_SWITCH, "3600000");
    }
}
