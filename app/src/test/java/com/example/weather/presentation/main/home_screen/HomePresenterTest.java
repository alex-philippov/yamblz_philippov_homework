package com.example.weather.presentation.main.home_screen;


import com.example.weather.domain.GetCurrentWeatherInteractor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class HomePresenterTest {


    @Mock
    private GetCurrentWeatherInteractor interactor;

    private HomePresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new HomePresenter(interactor);
    }

    @Test
    public void callInteractorOnAttach() {
        presenter.onAttach();
        verify(interactor).execute(any(), any());
    }

    @Test
    public void callInteractorOnRefresh() {
        presenter.refreshweather();
        verify(interactor).execute(any(), any());
    }
}
