package src.libraryManagementSystem.models;

import src.libraryManagementSystem.state.AvailableState;
import src.libraryManagementSystem.state.ItemState;

public class BookCopy {
    private final String id;
    private final LibraryItem item;
    private ItemState currentState;


    public BookCopy(String id, LibraryItem item) {
        this.id = id;
        this.item = item;
        this.currentState = new AvailableState();
        item.addBookCopy(this);
    }

    public String getId() {
        return id;
    }
    public void checkout(Member member) {
        currentState.checkOut(this, member);
    }
    public void setState(ItemState state) {
        this.currentState = state;
    }

    public LibraryItem getItem() {
        return item;
    }

    public void returnItem() {
        currentState.returnItem(this);
    }

    public boolean isAvailable() {
        return currentState instanceof AvailableState;
    }

    public  void placeHold(Member member) {
        currentState.placeHold(this, member);
    }



}
