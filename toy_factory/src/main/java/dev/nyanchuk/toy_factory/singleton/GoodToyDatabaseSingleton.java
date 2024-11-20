package dev.nyanchuk.toy_factory.singleton;

import dev.nyanchuk.toy_factory.db.GoodToyDatabase;

public class GoodToyDatabaseSingleton {

    private static GoodToyDatabase INSTANCE;

    private GoodToyDatabaseSingleton() {}

    public static GoodToyDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GoodToyDatabase();
        }
        return INSTANCE;
    }
}
