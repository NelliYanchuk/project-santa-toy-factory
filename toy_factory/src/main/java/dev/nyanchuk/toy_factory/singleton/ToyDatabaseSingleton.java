package dev.nyanchuk.toy_factory.singleton;

import dev.nyanchuk.toy_factory.db.ToyDatabase;

public class ToyDatabaseSingleton {

    private static ToyDatabase INSTANCE;

    private ToyDatabaseSingleton() {}

    public static ToyDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ToyDatabase();
        }
        return INSTANCE;
    }
}
