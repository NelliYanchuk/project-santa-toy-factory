package dev.nyanchuk.toy_factory.singleton;

import dev.nyanchuk.toy_factory.db.BadToyDatabase;

public class BadToyDatabaseSingleton {

    private static BadToyDatabase INSTANCE;

    private BadToyDatabaseSingleton() {}

    public static BadToyDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BadToyDatabase();
        }
        return INSTANCE;
    }
}
