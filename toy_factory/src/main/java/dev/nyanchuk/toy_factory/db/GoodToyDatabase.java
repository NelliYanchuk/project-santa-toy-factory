package dev.nyanchuk.toy_factory.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.nyanchuk.toy_factory.model.GoodToy;

public class GoodToyDatabase implements IDatabase<GoodToy> {

    private List<GoodToy> goodToys;

    public GoodToyDatabase() {
        initDB();
    }

    public List<GoodToy> getToys() {
        return goodToys;
    }

    public void save(GoodToy toy) {
        goodToys.add(toy);
        System.out.println("good Toy added");
    }

    private void initDB() {
        this.goodToys = new ArrayList<>(Arrays.asList(
                new GoodToy("B1", "Batman", true, "lego", 12, "construction")));
    }

}