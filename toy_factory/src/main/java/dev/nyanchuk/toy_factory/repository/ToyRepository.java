package dev.nyanchuk.toy_factory.repository;

import dev.nyanchuk.toy_factory.db.IDatabase;
import dev.nyanchuk.toy_factory.model.Toy;
import dev.nyanchuk.toy_factory.singleton.ToyDatabaseSingleton;

import java.util.Iterator;
import java.util.List;

public class ToyRepository {

    private IDatabase<Toy> toyDatabase;

    public ToyRepository() {
        this.toyDatabase = ToyDatabaseSingleton.getInstance();  // Singleton for ToyDatabase
    }

    // Fetch all toys (both good and bad)
    public List<Toy> getToys() {
        return toyDatabase.getToys();  // Get toys from database
    }

    // Save a toy (good or bad)
    public void saveToy(Toy toy) {
        toyDatabase.save(toy);  // Save the toy to database
    }
    // Delete a toy by ID
    public void deleteToyById(String toyId) {
        List<Toy> toys = toyDatabase.getToys();
        Iterator<Toy> iterator = toys.iterator();
        
        while (iterator.hasNext()) {
            Toy toy = iterator.next();
            if (toy.getId().equals(toyId)) {
                iterator.remove();  // Remove the toy from the list
                System.out.println("Toy with ID " + toyId + " has been deleted.");
                return;
            }
        }

        System.out.println("Toy with ID " + toyId + " not found.");
    }
}
