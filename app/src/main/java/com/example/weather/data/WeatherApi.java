package com.example.weather.data;

import com.example.weather.domain.entities.DetailedWeather;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    String URL = "http://api.openweathermap.org/data/2.5/";
    String API_KEY = "04820a12d1fb67f69232680d50cceda4";

    @GET("weather")
    Observable<DetailedWeather> getCurrentWeather(
            @Query("lat") float latitude,
            @Query("lon") float longitude,
            @Query("appid") String key);
}
