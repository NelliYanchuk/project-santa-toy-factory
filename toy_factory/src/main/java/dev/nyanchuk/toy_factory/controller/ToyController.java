package dev.nyanchuk.toy_factory.controller;

import dev.nyanchuk.toy_factory.model.Toy;
import dev.nyanchuk.toy_factory.repository.ToyRepository;
import dev.nyanchuk.toy_factory.view.ToyView;

import java.util.List;

public class ToyController {

    private final ToyRepository toyRepository;

    public ToyController() {
        this.toyRepository = new ToyRepository();
    }

    // Fetch all toys
    public List<Toy> getAllToys() {
        return toyRepository.getToys();
    }

    // Save a toy (good or bad)
    public void postToy(Toy toy) {
        toyRepository.saveToy(toy);
    }

    // Show all toys
    public void showToys() {
        List<Toy> toys = getAllToys();
        ToyView.displayToys(toys);
    }
}
