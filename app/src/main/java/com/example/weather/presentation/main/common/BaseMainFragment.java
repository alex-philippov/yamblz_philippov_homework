package com.example.weather.presentation.main.common;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.example.weather.presentation.common.BaseFragment;

public abstract class BaseMainFragment extends BaseFragment implements BaseMainView {
    public abstract String getTitle();

    @Override
    public void showError(@StringRes int message) {
        Toast.makeText(getContext(), getString(message), Toast.LENGTH_LONG).show();
    }

}
