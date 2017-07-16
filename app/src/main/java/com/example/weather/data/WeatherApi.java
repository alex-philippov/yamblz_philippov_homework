package com.example.weather.data;

import com.example.weather.domain.entities.DetailedWeather;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    public static final String URL = "http://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "04820a12d1fb67f69232680d50cceda4";

    @GET("weather")
    Single<DetailedWeather> getCurrentWeather(@Query("q") String q, @Query("appid") String key);
}
