package dev.nyanchuk.toy_factory.controller;

import dev.nyanchuk.toy_factory.model.*;
import dev.nyanchuk.toy_factory.repository.ToyRepository;
import dev.nyanchuk.toy_factory.view.ToyView;

import java.util.List;

public class ToyController {

    private final ToyRepository toyRepository;

    // Constructor initializes the repository
    public ToyController() {
        this.toyRepository = new ToyRepository();
    }

    // Method to add a default good toy
    public void addDefaultGoodToy(String id, String title, String brand, int targetAge, String category) {
        GoodToy goodToy = new GoodToy(id, title, true, brand, targetAge, category);
        postToy(goodToy);  // Save the good toy
    }

    // Method to add a default bad toy
    public void addDefaultBadToy(String id, String title, String content) {
        BadToy badToy = new BadToy(id, title, false, content);
        postToy(badToy);  // Save the bad toy
    }

    // Method to add default toys at the beginning
    public void addDefaultToys() {
        addDefaultGoodToy("G1", "Batman", "Lego", 12, "construction");
        addDefaultBadToy("B1", "Mystery Box 5x5", "coal");
    }

    // Method to fetch all toys
    public List<Toy> getAllToys() {
        return toyRepository.getToys();  // Fetch all toys from the repository
    }

    // Method to post a toy (good or bad)
    public void postToy(Toy toy) {
        toyRepository.saveToy(toy);  // Save the toy into the repository
    }

    // Method to show all toys
    public void showToys() {
        List<Toy> toys = getAllToys();
        ToyView toyView = new ToyView();
        toyView.displayToys(toys);  // Display the toys in the view
    }
}
