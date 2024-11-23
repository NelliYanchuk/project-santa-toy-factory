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

    // Method to generate next ID for a toy
    public String generateToyId(String toyType) {
        List<Toy> allToys = toyRepository.getToys();
        int maxId = 0;

        // Loop to find the highest ID number
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

        // Return ID +1
        return toyType.equals("good") ? "G" + (maxId + 1) : "B" + (maxId + 1);
    }

    // Method to add a default good toy
    public void addDefaultGoodToy(String title, String brand, int targetAge, String category) {
        String id = generateToyId("good"); // Generate ID for good toy
        GoodToy goodToy = new GoodToy(title, brand, targetAge, category);
        goodToy.setId(id);
        postGoodToy(goodToy);
    }

    // Method to add a default bad toy
    public void addDefaultBadToy(String title, String content) {
        String id = generateToyId("bad"); // Generate ID for bad toy
        BadToy badToy = new BadToy(title, content);
        badToy.setId(id);
        postBadToy(badToy);
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

    // Save good toy
    public void postGoodToy(Toy toy) {
        String id = generateToyId("good");
        toy.setId(id);
        toyRepository.saveToy(toy); // Save good toy into repository
    }

    // Save bad toy
    public void postBadToy(Toy toy) {
        String id = generateToyId("bad");
        toy.setId(id);
        toyRepository.saveToy(toy); // Save bad toy into repository
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
        Iterator<Toy> item = toys.iterator();
        while (item.hasNext()) {
            Toy toy = item.next();
            if (toy.getId().equals(toyId)) {
                item.remove();
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
        List<Toy> toys = toyRepository.getToys(); // Fetch all toys

        try (BufferedWriter file = new BufferedWriter(new FileWriter(fileName))) {
            // Write the header to the CSV file
            file.write("ID,Title,Type,Brand,Age,Category,Content\n");

            // Iterate over the toys and write each toy's details
            for (Toy toy : toys) {
                if (toy instanceof GoodToy) {
                    GoodToy goodToy = (GoodToy) toy;
                    file.write(String.format("%s,%s,%s,%s,%d,%s,\n",
                            goodToy.getId(),
                            goodToy.getTitle(),
                            "Good",
                            goodToy.getBrand(),
                            goodToy.getTargetAge(),
                            goodToy.getCategory()));
                } else if (toy instanceof BadToy) {
                    BadToy badToy = (BadToy) toy;
                    file.write(String.format("%s,%s,%s,,,,%s\n",
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
