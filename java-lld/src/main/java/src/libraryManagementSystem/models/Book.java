package src.libraryManagementSystem.models;

public class Book extends LibraryItem{
    private final String author;

    public Book(String id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    public String getAuthorOrPublisher() {
        return author;
    }
}
