package src.Library.Entities;

import src.Library.Entities.LibraryItem;

public class Book extends LibraryItem {
    private final String author;
    public Book( String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public String getAuthorOrPublisher() {
        return author;
    }
}
