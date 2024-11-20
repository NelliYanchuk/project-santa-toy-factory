package dev.nyanchuk.toy_factory.view;

import dev.nyanchuk.toy_factory.model.GoodToy;
import dev.nyanchuk.toy_factory.model.BadToy;
import dev.nyanchuk.toy_factory.model.Toy;

import java.util.ArrayList;
import java.util.List;

public class ToyView extends ShortMessage{

    // Method to display good toys
    public void displayGoodToys(List<GoodToy> goodToys) {
        toyMessage("good");
        for (GoodToy toy : goodToys) {
            System.out.println("Toy ID: " + toy.getId());
            System.out.println("Title: " + toy.getTitle());
            System.out.println("Brand: " + toy.getBrand());
            System.out.println("Age: " + toy.getTargetAge());
            System.out.println("Category: " + toy.getCategory());
        }
    }

    // Method to display bad toys
    public void displayBadToys(List<BadToy> badToys) {
        toyMessage("bad");
        for (BadToy toy : badToys) {
            System.out.println("Toy ID: " + toy.getId());
            System.out.println("Title: " + toy.getTitle());
            System.out.println("Content: " + toy.getContent());
        }
    }

    // Method to display all toys
    public void displayToys(List<Toy> toys) {
        List<GoodToy> goodToys = new ArrayList<>();
        List<BadToy> badToys = new ArrayList<>();

        // Segregate good and bad toys
        for (Toy toy : toys) {
            if (toy instanceof GoodToy) {
                goodToys.add((GoodToy) toy);
            } else if (toy instanceof BadToy) {
                badToys.add((BadToy) toy);
            }
        }

        // Call the respective methods to display good and bad toys
        displayGoodToys(goodToys);
        displayBadToys(badToys);
    }
}
