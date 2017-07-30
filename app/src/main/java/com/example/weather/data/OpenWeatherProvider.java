package com.example.weather.data;

import android.util.Log;

import com.example.weather.cache.CacheManager;
import com.example.weather.domain.entities.DetailedWeather;
import com.example.weather.cache.PreferencesManager;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class OpenWeatherProvider implements WeatherProvider {
    private static final String TAG = "OpenWeatherProvider";
    private PreferencesManager preferencesManager;
    private CacheManager cacheManager;
    private WeatherApi weatherApi;

    public OpenWeatherProvider(WeatherApi weatherApi,
                               CacheManager cacheManager,
                               PreferencesManager preferencesManager) {
        this.weatherApi = weatherApi;
        this.cacheManager = cacheManager;
        this.preferencesManager = preferencesManager;
    }

    @Override
    public Observable<DetailedWeather> getWeather(String key) {
        float latitude = preferencesManager.getLatitude();
        float longitude = preferencesManager.getLongitude();
        Observable<DetailedWeather> observable = weatherApi.getCurrentWeather(latitude, longitude, key)
                .subscribeOn(Schedulers.io())
                .doOnNext(detailedWeather -> cacheManager.saveWeather(detailedWeather));

        DetailedWeather cachedWeather = cacheManager.getLastWeather();

        if (cachedWeather != null) {
            observable = Observable.mergeDelayError(observable, Observable.just(cachedWeather));
        }
        observable.subscribe(detailedWeather ->
                Log.i(TAG, "getWeather: " + detailedWeather.toString()),
                err -> Log.d(TAG, "error, stack trace: " + err.getMessage()));

        return observable;
    }
}
