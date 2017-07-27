package com.example.weather.presentation;

import android.content.Context;

public class PreferenceManager {
    public static int pereodic = 900000;
    private Context context;

    public PreferenceManager(Context context) {
        this.context = context;
    }

    public void setPereodic(int p) {
        pereodic = p;
    }

}
