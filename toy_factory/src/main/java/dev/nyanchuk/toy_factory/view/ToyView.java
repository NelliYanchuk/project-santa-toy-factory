package dev.nyanchuk.toy_factory.view;

import dev.nyanchuk.toy_factory.model.GoodToy;

import java.util.List;

public class ToyView {

    // Method to display all good toys
    public static void displayGoodToys(List<GoodToy> goodToys) {
        if (goodToys == null || goodToys.isEmpty()) {
            System.out.println("\nNo good toys available.");
            return;
        }

        for (GoodToy toy : goodToys) {
            System.out.println("\nTitle: " + toy.getTitle());
            System.out.println("Brand: " + toy.getBrand());
            System.out.println("Recommended Age: " + toy.getTargetAge());
            System.out.println("Category: " + toy.getCategory());
            System.out.println("-----------------------------------------");
        }
    }
}
