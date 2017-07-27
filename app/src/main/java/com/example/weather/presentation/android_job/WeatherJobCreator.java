package com.example.weather.presentation.android_job;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

public class WeatherJobCreator implements JobCreator {
    @Override
    public Job create(String tag) {
        switch (tag) {
            case WeatherJob.TAG:
                return new WeatherJob();
            default:
                return null;
        }
    }
}
