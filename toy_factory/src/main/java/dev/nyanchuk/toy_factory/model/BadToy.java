package dev.nyanchuk.toy_factory.model;

public class BadToy extends Toy {

    String content;

    public BadToy(String title, String content, boolean isGoodToy) {
        super(title, isGoodToy); // Calls the constructor of Toy
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
