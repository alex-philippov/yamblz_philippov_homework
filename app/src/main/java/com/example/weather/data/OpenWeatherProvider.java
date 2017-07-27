package com.example.weather.data;

import android.util.Log;

import com.example.weather.cache.CacheManager;
import com.example.weather.domain.entities.DetailedWeather;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class OpenWeatherProvider implements WeatherProvider {
    public static final String TAG = "tag_open_weather";
    private CacheManager cacheManager;
    private WeatherApi weatherApi;

    public OpenWeatherProvider(WeatherApi weatherApi, CacheManager cacheManager) {
        this.weatherApi = weatherApi;
        this.cacheManager = cacheManager;
    }

    @Override
    public Observable<DetailedWeather> getWeather(String city, String key) {
        Observable<DetailedWeather> observable = weatherApi.getCurrentWeather(city, key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(detailedWeather -> cacheManager.saveWeather(detailedWeather));

        DetailedWeather cachedWeather = cacheManager.getLastWeather();

        if (cachedWeather != null) {
            observable = Observable.mergeDelayError(observable, Observable.just(cachedWeather));
        }
        observable.subscribe(detailedWeather ->
                Log.i(TAG, "getWeather: " + detailedWeather.toString()));

        return observable;
    }
}
