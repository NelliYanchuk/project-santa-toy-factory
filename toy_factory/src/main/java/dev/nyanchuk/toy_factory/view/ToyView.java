package dev.nyanchuk.toy_factory.view;

import dev.nyanchuk.toy_factory.model.*;

import java.util.List;

public class ToyView {

    // Method to display all toys
    public static void displayToys(List<Toy> toys) {
        if (toys == null || toys.isEmpty()) {
            System.out.println("No toys available.");
            return;
        }

        for (Toy toy : toys) {
            System.out.println("Toy ID: " + toy.getId());
            System.out.println("Title: " + toy.getTitle());
            // Add other details if necessary (e.g., for good toys: brand, category)
            if (toy instanceof GoodToy) {
                GoodToy goodToy = (GoodToy) toy;
                System.out.println("Brand: " + goodToy.getBrand());
                System.out.println("Age: " + goodToy.getTargetAge());
                System.out.println("Category: " + goodToy.getCategory());
            } else if (toy instanceof BadToy) {
                BadToy badToy = (BadToy) toy;
                System.out.println("Content: " + badToy.getContent());
            }
            System.out.println("-----------------------------------------");
        }
    }
}
