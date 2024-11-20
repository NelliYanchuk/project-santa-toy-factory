package dev.nyanchuk.toy_factory.controller;

import dev.nyanchuk.toy_factory.view.HomeView;

public class HomeController {

    private final ToyController toyController;  // Inject the ToyController

    public HomeController() {
        this.toyController = new ToyController();
        toyController.addDefaultToys();  // Add default toys when the app starts
        index();
    }

    public void index() {
        // Show Home Menu
        HomeView.index();
    }
}
