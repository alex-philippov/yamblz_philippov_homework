package com.example.weather.presentation.main;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class MainPresenterTest {

    @Mock
    private MainRouter router;

    private MainPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new MainPresenter();
        presenter.setRouter(router);
    }

    @Test
    public void checkHomeSelection() {
        presenter.selectedHome();
        verify(router).showHomeScreen();
    }

    @Test
    public void checkSettingsSelection() {
        presenter.selectedSettings();
        verify(router).showSettingsScreen();
    }

    @Test
    public void checkAboutAppSelection() {
        presenter.selectedAboutApp();
        verify(router).showAboutApplicationScreen();
    }
}
