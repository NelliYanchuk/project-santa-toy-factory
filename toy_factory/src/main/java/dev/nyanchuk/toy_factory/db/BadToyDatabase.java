package dev.nyanchuk.toy_factory.db;

import dev.nyanchuk.toy_factory.model.BadToy;
import java.util.ArrayList;
import java.util.List;

public class BadToyDatabase implements IDatabase<BadToy> {

    private List<BadToy> badToys;

    // Constructor initializes the list of bad toys
    public BadToyDatabase() {
        this.badToys = new ArrayList<>();
    }

    // Get all bad toys
    @Override
    public List<BadToy> getToys() {
        return badToys;
    }

    // Save a bad toy
    @Override
    public void save(BadToy toy) {
        badToys.add(toy);
    }
}
