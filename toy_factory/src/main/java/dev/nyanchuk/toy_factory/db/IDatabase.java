package dev.nyanchuk.toy_factory.db;

import java.util.List;

// Generics
public interface IDatabase<E> {

    public void save(E entity);
    public List<E> getToys();

}