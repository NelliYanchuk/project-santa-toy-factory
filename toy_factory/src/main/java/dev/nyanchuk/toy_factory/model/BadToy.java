package dev.nyanchuk.toy_factory.model;

public class BadToy extends Toy {

    private String content;

    // Constructor without ID
    public BadToy(String title, String content) {
        super(title, false);  // ID will be set by ToyController
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
