package com.example.weather.presentation.common;

public abstract class BasePresenter<View, Router> {
    private View view;
    private Router router;

    public abstract void onAttach();

    public abstract void onDetach();

    public void setView(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public Router getRouter() {
        return router;
    }
}
