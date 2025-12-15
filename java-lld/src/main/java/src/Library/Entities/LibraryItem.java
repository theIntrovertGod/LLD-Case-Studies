package src.Library.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class LibraryItem {

    private final String id;
    private final String title;
    protected final List<BookCopy> copies = new ArrayList<>();
    private final List<Member> observers = new ArrayList<>();

    public LibraryItem(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void addCopy(BookCopy copy) {
        this.copies.add(copy);
    }

    public void removerCopy(BookCopy copy) {
        this.copies.remove(copy);
    }

    public String getTitle() {
        return title;
    }

    public abstract String getAuthorOrPublisher();

//    add OObserver, removeObserver/

    public void addObserver(Member member) {
        observers.add(member);
    }

    public void removeObserver(Member member) {
        observers.remove(member);
    }

    public boolean isObserver (Member memeber) {
        return observers.contains(memeber);
    }

    public BookCopy getAvailableCopy() {
        return copies.stream()
                .filter(BookCopy :: isAvailable)
                .findFirst()
                .orElse(null);
    }

    //    notifyObservers
    public  void notifyObservers() {
        System.out.println("Notifying Observers of the LibraryItem : " + this.getTitle());
        new ArrayList<>(observers).forEach(observer -> observer.update(this));
    }

    public List<BookCopy> getCopies() {
        return copies;
    }
}
