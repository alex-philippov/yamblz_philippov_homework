package com.example.weather.utils;

import com.google.android.gms.maps.model.LatLng;

public interface OnCityChangeListener {
    void cityChanged(LatLng latLng);
}
