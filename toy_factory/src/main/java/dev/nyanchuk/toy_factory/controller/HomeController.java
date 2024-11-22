package dev.nyanchuk.toy_factory.controller;

import dev.nyanchuk.toy_factory.view.HomeView;

public class HomeController {

    private final ToyController toyController;

    public HomeController() {
        this.toyController = new ToyController();
        toyController.addDefaultToys(); // Add default toys when the app starts
        index();
    }

    public void index() {
        HomeView.index();
    }
}
