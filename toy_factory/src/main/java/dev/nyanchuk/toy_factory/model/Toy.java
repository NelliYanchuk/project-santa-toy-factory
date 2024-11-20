package dev.nyanchuk.toy_factory.model;

public abstract class Toy {

    protected String id;
    protected String title;
    protected boolean isGoodToy;

    // Constructor for Toy with a title and a flag for good/bad
    public Toy(String title, boolean isGoodToy) {
        this.title = title;
        this.isGoodToy = isGoodToy;
    }

    // Constructor for Toy with an ID and title
    public Toy(String id, String title, boolean isGoodToy) {
        this.id = id;
        this.title = title;
        this.isGoodToy = isGoodToy;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isGoodToy() {
        return isGoodToy;
    }

    public void setGoodToy(boolean isGoodToy) {
        this.isGoodToy = isGoodToy;
    }
}
