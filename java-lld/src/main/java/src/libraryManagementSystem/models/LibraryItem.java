package src.libraryManagementSystem.models;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
//
//LibraryItem magzine = new LibraryItem();
//magzine
public abstract class LibraryItem {
    private String id;
    private String title;
    protected final List<BookCopy> copies = new ArrayList<>();
    //Observer Pattern: List of Members waitng for this item
    private final List<Member> observers = new ArrayList<>();

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public void addBookCopy(BookCopy copy) {
        copies.add(copy);
    }
    public void addObserver(src.libraryManagementSystem.models.Member member) {
        observers.add((Member) member);
    }

    public void removeObserver(src.libraryManagementSystem.models.Member member) {
        observers.remove(member);
    }

    public void notifyObservers() {
        for (Member member : observers) {
//            member.up(this);
        }
//        new ArrayList<>(observers.forEach(observer -> observer.update(this));
    }

//    public BookCopy getAvailableCopy() {
//        //will come back
//        return copies.stream().
//        .fil
//    }

    public String getId(){
        return id;
    }
    public String getTitle() {
        return title;
    }

    public List<BookCopy> getCopies() {
        return copies;
    }

//
    public boolean hasObservers() {
        return !observers.isEmpty();
    }

    public boolean isObserver(src.libraryManagementSystem.models.Member member) {
        return observers.contains(member);
    }

    public abstract String getAuthorOrPublisher();







}
