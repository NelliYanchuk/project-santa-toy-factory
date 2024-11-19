package dev.nyanchuk.toy_factory.singleton;

import dev.nyanchuk.toy_factory.repository.ToyRepository;

public class ToyRepositorySingleton {

    private static final ToyRepository INSTANCE = new ToyRepository();

    private ToyRepositorySingleton() {
    }

    public static ToyRepository getInstance() {
        return INSTANCE;
    }

}
