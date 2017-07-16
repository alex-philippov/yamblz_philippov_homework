package com.example.weather.presentation.android_job;

import android.support.annotation.NonNull;
import android.util.Log;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.example.weather.WeatherApp;

public class WeatherJob extends Job {
    public static final String TAG = "job_weather_tag";

    @NonNull
    @Override
    protected Result onRunJob(Params params) {
        Log.i(TAG, "onRunJob: ");
        return Result.SUCCESS;
    }

    public static void scheduleJob() {
        new JobRequest.Builder(WeatherJob.TAG)
                .setPersisted(true)
                .setPeriodic(900000)
                .setRequiredNetworkType(JobRequest.NetworkType.CONNECTED)
                .build()
                .schedule();
    }
}
