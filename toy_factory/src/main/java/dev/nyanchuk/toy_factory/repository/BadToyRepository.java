package dev.nyanchuk.toy_factory.repository;

import dev.nyanchuk.toy_factory.db.IDatabase;
import dev.nyanchuk.toy_factory.model.BadToy;
import dev.nyanchuk.toy_factory.singleton.BadToyDatabaseSingleton;

import java.util.List;

public class BadToyRepository {

    private final IDatabase<BadToy> badToyDatabase;

    public BadToyRepository() {
        this.badToyDatabase = BadToyDatabaseSingleton.getInstance();
    }

    // Fetch all bad toys
    public List<BadToy> getBadToys() {
        return badToyDatabase.getToys();
    }

    // Save a bad toy
    public void saveBadToy(BadToy toy) {
        badToyDatabase.save(toy);
    }
}
