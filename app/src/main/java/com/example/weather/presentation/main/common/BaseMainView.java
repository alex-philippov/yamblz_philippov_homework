package com.example.weather.presentation.main.common;

import android.support.annotation.StringRes;

public interface BaseMainView {
    void showError(@StringRes int message);
    void showLoad();
    void hideLoad();
}
