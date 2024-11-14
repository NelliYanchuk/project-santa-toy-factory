package dev.nyanchuk.toy_factory.controller;

import dev.nyanchuk.toy_factory.view.HomeView;

public class HomeController {

    public HomeController() {
        index();
    }

    public void index() {
        // Show Home Menu
        HomeView.index();
    }

}
