package dev.nyanchuk.toy_factory.repository;

import dev.nyanchuk.toy_factory.db.IDatabase;
import dev.nyanchuk.toy_factory.model.Toy;
import dev.nyanchuk.toy_factory.singleton.ToyDatabaseSingleton;

import java.util.List;

public class ToyRepository {

    private IDatabase<Toy> toyDatabase;

    public ToyRepository() {
        this.toyDatabase = ToyDatabaseSingleton.getInstance();  // Singleton for ToyDatabase
    }

    // Fetch all toys (both good and bad)
    public List<Toy> getToys() {
        return toyDatabase.getToys();
    }

    // Save a toy (good or bad)
    public void saveToy(Toy toy) {
        toyDatabase.save(toy);
    }
}
