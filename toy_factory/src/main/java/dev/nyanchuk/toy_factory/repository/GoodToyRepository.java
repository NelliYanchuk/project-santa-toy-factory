package dev.nyanchuk.toy_factory.repository;

import dev.nyanchuk.toy_factory.db.ToyDatabase;
import dev.nyanchuk.toy_factory.model.GoodToy;
import dev.nyanchuk.toy_factory.singleton.ToyDatabaseSingleton;

import java.util.List;

public class GoodToyRepository {

    private final ToyDatabase toyDatabase;  // Using ToyDatabase for all toy types

    public GoodToyRepository() {
        this.toyDatabase = ToyDatabaseSingleton.getInstance();  // Singleton for ToyDatabase
    }

    // Fetch all good toys
    public List<GoodToy> getGoodToys() {
        return toyDatabase.getToys().stream()
                          .filter(toy -> toy instanceof GoodToy)  // Filter good toys
                          .map(toy -> (GoodToy) toy)  // Cast to GoodToy
                          .toList();
    }

    // Save a good toy
    public void saveGoodToy(GoodToy toy) {
        toyDatabase.save(toy);  // Save the good toy
    }
}
