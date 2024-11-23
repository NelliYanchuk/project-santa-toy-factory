package dev.nyanchuk.toy_factory.model;

public class GoodToy extends Toy {

    private String brand;
    private int targetAge;
    private String category;

    public GoodToy(String title, String brand, int targetAge, String category) {
        super(title, true);  // ID will be set by ToyController in ElfView
        this.brand = brand;
        this.targetAge = targetAge;
        this.category = category;
    }

    // Getters and setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getTargetAge() {
        return targetAge;
    }

    public void setTargetAge(int targetAge) {
        this.targetAge = targetAge;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
