package com.example.weather.presentation.android_job;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.example.weather.WeatherApp;
import com.example.weather.domain.GetCurrentWeatherInteractor;
import com.example.weather.domain.entities.DetailedWeather;
import com.example.weather.presentation.PreferenceManager;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class WeatherJob extends Job {
    public static final String TAG = "job_weather_tag";

    @Inject
    GetCurrentWeatherInteractor getCurrentWeatherInteractor;

    @NonNull
    @Override
    protected Result onRunJob(Params params) {
        Log.i(TAG, "onRunJob: ");
        getCurrentWeatherInteractor.execute("Moscow", detailedWeather -> {
            Log.i(TAG, "onRunJob: get weather");
        }, throwable -> {
            Log.i(TAG, "onRunJob: error");
        });
        return Result.SUCCESS;
    }

    public static void scheduleJob() {
        Log.i(TAG, "scheduleJob: ");

        new JobRequest.Builder(WeatherJob.TAG)
                .setPersisted(true)
                .setPeriodic(PreferenceManager.pereodic)
                .setRequiredNetworkType(JobRequest.NetworkType.CONNECTED)
                .build()
                .schedule();
    }
}
