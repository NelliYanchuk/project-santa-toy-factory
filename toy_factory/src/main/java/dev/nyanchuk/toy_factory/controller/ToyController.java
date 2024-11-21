package dev.nyanchuk.toy_factory.controller;

import dev.nyanchuk.toy_factory.model.*;
import dev.nyanchuk.toy_factory.repository.ToyRepository;
import dev.nyanchuk.toy_factory.view.ToyView;

import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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
            if ((toyType.equals("good") && toy instanceof GoodToy)
                    || (toyType.equals("bad") && toy instanceof BadToy)) {
                String id = toy.getId();
                // Extract the number from the ID
                int idNum = Integer.parseInt(id.substring(1)); // Extract the numeric part of the ID
                if (idNum > maxId) {
                    maxId = idNum;
                }
            }
        }

        // Return the next ID +1
        return toyType.equals("good") ? "G" + (maxId + 1) : "B" + (maxId + 1);
    }

    // Method to add a default good toy
    public void addDefaultGoodToy(String title, String brand, int targetAge, String category) {
        String id = generateToyId("good"); // Generate the ID for the good toy
        GoodToy goodToy = new GoodToy(title, brand, targetAge, category); // ID will be set automatically
        goodToy.setId(id); // Explicitly set the generated ID
        postToy(goodToy); // Save the good toy
    }

    // Method to add a default bad toy
    public void addDefaultBadToy(String title, String content) {
        String id = generateToyId("bad"); // Generate the ID for the bad toy
        BadToy badToy = new BadToy(title, content); // ID will be set automatically
        badToy.setId(id); // Explicitly set the generated ID
        postToy(badToy); // Save the bad toy
    }

    // Method to add default toys at the beginning
    public void addDefaultToys() {
        addDefaultGoodToy("Batman", "Lego", 12, "construction");
        addDefaultBadToy("Mystery Box 5x5", "coal");
    }

    // Fetch all toys
    public List<Toy> getAllToys() {
        return toyRepository.getToys(); // Fetch all toys from the repository
    }

    // Save a toy (good or bad)
    public void postToy(Toy toy) {
        toyRepository.saveToy(toy); // Save the toy into the repository
    }

    // Show all toys
    public void showToys() {
        List<Toy> toys = getAllToys();
        ToyView toyView = new ToyView();
        toyView.displayToys(toys); // Display the toys in the view
    }

    // Delete toy by ID
    public void deleteToyById(String toyId) {
        List<Toy> toys = getAllToys();
        Iterator<Toy> iterator = toys.iterator();
        while (iterator.hasNext()) {
            Toy toy = iterator.next();
            if (toy.getId().equals(toyId)) {
                iterator.remove(); // Remove toy with matching ID
                System.out.println("Toy with ID " + toyId + " has been deleted.");
                return;
            }
        }
        System.out.println("Toy with ID " + toyId + " not found.");
    }

    // Method to show only good toys
    public void showGoodToys() {
        List<Toy> toys = getAllToys(); // Fetch all toys from the repository
        List<GoodToy> goodToys = new ArrayList<>();
        for (Toy toy : toys) {
            if (toy instanceof GoodToy) {
                goodToys.add((GoodToy) toy); // Add to good toys list
            }
        }
        ToyView toyView = new ToyView();
        toyView.displayGoodToys(goodToys); // Display only good toys
    }

    // Method to show only bad toys
    public void showBadToys() {
        List<Toy> toys = getAllToys(); // Fetch all toys from the repository
        List<BadToy> badToys = new ArrayList<>();
        for (Toy toy : toys) {
            if (toy instanceof BadToy) {
                badToys.add((BadToy) toy); // Add to bad toys list
            }
        }
        ToyView toyView = new ToyView();
        toyView.displayBadToys(badToys); // Display only bad toys
    }

    // Method to save all toys to a CSV file
    public void saveToysToCsv(String fileName) {
        List<Toy> toys = toyRepository.getToys();  // Fetch all toys

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write the header to the CSV file
            writer.write("ID,Title,Type,Brand,Age,Category,Content\n");

            // Iterate over the toys and write each toy's details
            for (Toy toy : toys) {
                if (toy instanceof GoodToy) {
                    GoodToy goodToy = (GoodToy) toy;
                    writer.write(String.format("%s,%s,%s,%s,%d,%s,\n",
                            goodToy.getId(),
                            goodToy.getTitle(),
                            "Good",
                            goodToy.getBrand(),
                            goodToy.getTargetAge(),
                            goodToy.getCategory()));
                } else if (toy instanceof BadToy) {
                    BadToy badToy = (BadToy) toy;
                    writer.write(String.format("%s,%s,%s,,,,%s\n",
                            badToy.getId(),
                            badToy.getTitle(),
                            "Bad",
                            badToy.getContent()));
                }
            }
            System.out.println("Toys have been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving toys to CSV: " + e.getMessage());
        }
    }
}
