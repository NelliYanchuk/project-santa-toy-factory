package dev.nyanchuk.toy_factory.model;

public class BadToy extends Toy {

    private String content;

    public BadToy(String title, String content) {
        super(title, false);  // Pass the correct values to the parent constructor
        this.content = content;
    }

    public BadToy(String id, String title, String content) {
        super(id, title, false);  // Pass the correct values to the parent constructor
        this.content = content;
    }

    // Getter and setter
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
