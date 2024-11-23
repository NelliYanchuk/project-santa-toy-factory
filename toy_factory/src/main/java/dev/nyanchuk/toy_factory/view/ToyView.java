package dev.nyanchuk.toy_factory.view;

import dev.nyanchuk.toy_factory.model.*;

import java.util.ArrayList;
import java.util.List;

public class ToyView extends ShortMessageView {

    String goodType = "good";
    String badType = "bad";

    // Method to display good toys
    public void displayGoodToys(List<GoodToy> goodToys) {
        if (goodToys == null || goodToys.isEmpty()) {
            noToyMessage(goodType);
            return; // Exit the method if no toys are found
        }

        toyMessage(goodType);
        for (GoodToy toy : goodToys) {
            System.out.println(" * " + toy.getId()
                    + ". Title: " + toy.getTitle()
                    + ", Brand: " + toy.getBrand()
                    + ", Recommended Age: " + toy.getTargetAge()
                    + ", Category: " + toy.getCategory());
        }
    }

    // Method to display bad toys
    public void displayBadToys(List<BadToy> badToys) {
        if (badToys == null || badToys.isEmpty()) {
            noToyMessage(badType);
            return; // Exit the method if no toys are found
        }

        toyMessage(badType);
        for (BadToy toy : badToys) {
            System.out.println(" * " + toy.getId()
                    + ". Title: " + toy.getTitle()
                    + ", Content: " + toy.getContent());
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

        if ((badToys == null || badToys.isEmpty()) && (goodToys == null || goodToys.isEmpty())) {
            System.out.println("Stock does not have any toy left.");
            ;
            return; // Exit the method if no toys are found
        }

        // Call the methods to display good and bad toys
        displayGoodToys(goodToys);
        displayBadToys(badToys);
    }
}
