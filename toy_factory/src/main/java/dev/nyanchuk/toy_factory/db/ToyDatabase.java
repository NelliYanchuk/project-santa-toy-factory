package dev.nyanchuk.toy_factory.db;

import dev.nyanchuk.toy_factory.model.Toy;
import java.util.ArrayList;
import java.util.List;

public class ToyDatabase implements IDatabase<Toy> {

    private List<Toy> toyStorage;

    public ToyDatabase() {
        toyStorage = new ArrayList<>();
    }

    // Save a toy (good or bad)
    @Override
    public void save(Toy toy) {
        toyStorage.add(toy);
        System.out.println("\n" + toy.getTitle() + " added");
    }

    // Get all toys
    @Override
    public List<Toy> getToys() {
        return toyStorage;
    }
}
