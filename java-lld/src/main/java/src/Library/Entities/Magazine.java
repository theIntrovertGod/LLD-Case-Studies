package src.Library.Entities;

public class Magazine extends LibraryItem{
    private final String publisher;
    public Magazine(String title, String publisher) {
        super(title);
        this.publisher = publisher;
    }

    @Override
    public String getAuthorOrPublisher() {
        return publisher;
    }
}
