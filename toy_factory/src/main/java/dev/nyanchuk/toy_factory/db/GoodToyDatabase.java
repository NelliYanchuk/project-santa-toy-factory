package dev.nyanchuk.toy_factory.db;

import dev.nyanchuk.toy_factory.model.GoodToy;
import java.util.ArrayList;
import java.util.List;

public class GoodToyDatabase implements IDatabase<GoodToy> {

    private List<GoodToy> goodToys;

    // Constructor initializes the list of good toys
    public GoodToyDatabase() {
        this.goodToys = new ArrayList<>();
    }

    // Get all good toys
    @Override
    public List<GoodToy> getToys() {
        return goodToys;
    }

    // Save a good toy
    @Override
    public void save(GoodToy toy) {
        goodToys.add(toy);
    }
}
