package dev.nyanchuk.toy_factory.repository;

import dev.nyanchuk.toy_factory.db.ToyDatabase;
import dev.nyanchuk.toy_factory.model.BadToy;
import dev.nyanchuk.toy_factory.singleton.ToyDatabaseSingleton;

import java.util.List;

public class BadToyRepository {

    private final ToyDatabase toyDatabase;  // Using ToyDatabase for all toy types

    public BadToyRepository() {
        this.toyDatabase = ToyDatabaseSingleton.getInstance();  // Singleton for ToyDatabase
    }

    // Fetch all bad toys
    public List<BadToy> getBadToys() {
        return toyDatabase.getToys().stream()
                          .filter(toy -> toy instanceof BadToy)  // Filter bad toys
                          .map(toy -> (BadToy) toy)  // Cast to BadToy
                          .toList();
    }

    // Save a bad toy
    public void saveBadToy(BadToy toy) {
        toyDatabase.save(toy);  // Save the bad toy
    }
}
