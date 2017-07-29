package com.example.weather.cache;


import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)

public class PreferencesManagerTest {

    private SharedPreferences sharedPreferences;
    private PreferencesManager preferencesManager;

    private final String SP_NAME = "TEST_SP";
    private final String DEFAULT_UPDATE_INTERVAL = "3600000";
    private final boolean DEFAULT_FIRST_TIME_USER = true;
    private final float DEFAULT_LATITUDE = 55.7558F;
    private final float DEFAULT_LONGITUDE = 37.6173F;

    private final float ACTUAL_LATITUDE = 51.5074F;
    private final float ACTUAL_LONGITUDE = 0.1278F;
    private final boolean ACTUAL_FIRST_TIME_USER = false;


    @Before
    public void setup() {
        sharedPreferences = RuntimeEnvironment.
                application.getSharedPreferences(SP_NAME, 0);
        sharedPreferences.edit().clear().apply();
        preferencesManager = new PreferencesManager(sharedPreferences);
    }

    @Test
    public void checkPreferencesInitialization() {
        assertNotNull(sharedPreferences);
        assertNotNull(preferencesManager);
    }

    @Test
    public void checkDefaultUpdateInterval() {
        assertEquals(DEFAULT_UPDATE_INTERVAL, preferencesManager.getCurrentUpdateInterval());
    }

    @Test
    public void checkDefaultLatitude() {
        assertEquals(DEFAULT_LATITUDE, preferencesManager.getLatitude());
    }

    @Test
    public void checkDefaultLongitude() {
        assertEquals(DEFAULT_LONGITUDE, preferencesManager.getLongitude());
    }

    @Test
    public void checkDefaultFirstTimeUser() {
        assertEquals(DEFAULT_FIRST_TIME_USER, preferencesManager.getFirstTimeUser());
    }

    @Test
    public void setActualLatitude() {
        preferencesManager.setLatitude(ACTUAL_LATITUDE);

        assertEquals(ACTUAL_LATITUDE, preferencesManager.getLatitude());
    }

    @Test
    public void setActualLongitude() {
        preferencesManager.setLongitude(ACTUAL_LONGITUDE);

        assertEquals(ACTUAL_LONGITUDE, preferencesManager.getLongitude());
    }

    @Test
    public void setFirstTimeUser() {
        preferencesManager.setFirstTimeUser(ACTUAL_FIRST_TIME_USER);

        assertEquals(ACTUAL_FIRST_TIME_USER, preferencesManager.getFirstTimeUser());
    }
}
