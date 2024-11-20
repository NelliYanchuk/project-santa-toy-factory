package dev.nyanchuk.toy_factory.repository;

import dev.nyanchuk.toy_factory.db.IDatabase;
import dev.nyanchuk.toy_factory.model.GoodToy;
import dev.nyanchuk.toy_factory.singleton.*;

import java.util.List;

public class GoodToyRepository {

    private final IDatabase<GoodToy> goodToyDatabase;

    public GoodToyRepository() {
        this.goodToyDatabase = GoodToyDatabaseSingleton.getInstance();
    }

    // Fetch all good toys
    public List<GoodToy> getGoodToys() {
        return goodToyDatabase.getToys();
    }

    // Save a good toy
    public void saveGoodToy(GoodToy toy) {
        goodToyDatabase.save(toy);
    }
}
