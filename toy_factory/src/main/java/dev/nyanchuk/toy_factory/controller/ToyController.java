package dev.nyanchuk.toy_factory.controller;

import dev.nyanchuk.toy_factory.model.*;
import dev.nyanchuk.toy_factory.repository.ToyRepository;
import dev.nyanchuk.toy_factory.view.ToyView;

import java.util.List;

public class ToyController {

    private final ToyRepository toyRepository;

    public ToyController() {
        this.toyRepository = new ToyRepository();
    }

    // Generate the next ID for a good toy or bad toy
    public String generateToyId(String toyType) {
        List<Toy> allToys = toyRepository.getToys();
        int maxId = 0;

        // Loop through the toys to find the highest ID number
        for (Toy toy : allToys) {
            // Check if the toy is of the specified type (good or bad)
            if ((toyType.equals("good") && toy instanceof GoodToy) || (toyType.equals("bad") && toy instanceof BadToy)) {
                String id = toy.getId();
                // Extract the number from the ID
                int idNum = Integer.parseInt(id.substring(1));  // Extract the numeric part of the ID
                // Keep track of the highest number
                if (idNum > maxId) {
                    maxId = idNum;
                }
            }
        }

        // Return the next ID (incremented by 1)
        return toyType.equals("good") ? "G" + (maxId + 1) : "B" + (maxId + 1);
    }

    // Method to add a default good toy
    public void addDefaultGoodToy(String title, String brand, int targetAge, String category) {
        String id = generateToyId("good");  // Generate the ID for the good toy
        GoodToy goodToy = new GoodToy(title, brand, targetAge, category);  // Create the good toy without ID
        goodToy.setId(id);  // Now set the ID for the good toy
        postToy(goodToy);  // Save the good toy
    }

    // Method to add a default bad toy
    public void addDefaultBadToy(String title, String content) {
        String id = generateToyId("bad");  // Generate the ID for the bad toy
        BadToy badToy = new BadToy(title, content);  // Create the bad toy without ID
        badToy.setId(id);  // Now set the ID for the bad toy
        postToy(badToy);  // Save the bad toy
    }

    // Method to add default toys at the beginning
    public void addDefaultToys() {
        addDefaultGoodToy("Batman", "Lego", 12, "construction");
        addDefaultBadToy("Mystery Box 5x5", "coal");
    }

    // Fetch all toys
    public List<Toy> getAllToys() {
        return toyRepository.getToys();  // Fetch all toys from the repository
    }

    // Save a toy (good or bad)
    public void postToy(Toy toy) {
        toyRepository.saveToy(toy);  // Save the toy into the repository
    }

    // Show all toys
    public void showToys() {
        List<Toy> toys = getAllToys();
        ToyView toyView = new ToyView();
        toyView.displayToys(toys);  // Display the toys in the view
    }
}
