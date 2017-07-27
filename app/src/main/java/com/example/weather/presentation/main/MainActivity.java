package com.example.weather.presentation.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.weather.R;
import com.example.weather.WeatherApp;
import com.example.weather.presentation.common.BaseActivity;
import com.example.weather.presentation.common.BasePresenter;
import com.example.weather.presentation.main.aboutapp_screen.AboutAppFragment;
import com.example.weather.presentation.main.home_screen.HomeFragment;
import com.example.weather.presentation.main.settings_screen.SettingsFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity
        implements MainRouter, MainView, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_main_frame, HomeFragment.newInstance())
                    .commit();
        }
    }

    @Override
    public MainPresenter getPresenter() {
        return mainPresenter;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_settings) {
            getPresenter().selectedSettings();
        } else if (id == R.id.nav_about_app) {
            getPresenter().selectedAboutApp();
        } else if (id == R.id.nav_home) {
            getPresenter().selectedHome();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showHomeScreen() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_main_frame, HomeFragment.newInstance())
                .commit();
    }

    @Override
    public void showSettingsScreen() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_main_frame, SettingsFragment.newInstance())
                .commit();
    }

    @Override
    public void showAboutApplicationScreen() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_main_frame, AboutAppFragment.newInstance())
                .commit();
    }

    @Override
    public void showError(@StringRes int message) {

    }

    @Override
    public void showLoad() {

    }

    @Override
    public void hideLoad() {

    }

    @Override
    protected void inject() {
        WeatherApp.getInstance().plusMainActivityComponent().inject(this);
    }
}
