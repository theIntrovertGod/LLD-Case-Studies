package src.Library.Entities;

import src.Library.states.AvailableState;
import src.Library.states.ItemState;

import java.util.UUID;

public class BookCopy {
    private final String id;
    private final LibraryItem item;
    private ItemState currentState;

    public BookCopy(LibraryItem item) {
        this.id = UUID.randomUUID().toString();
        this.item = item;
        this.currentState = new AvailableState();
    }

    public LibraryItem getItem() {
        return item;
    }

    public String getId() {
        return id;
    }

    public void setState (ItemState state){
        this.currentState = state;
    }

    public boolean isAvailable() {
        return currentState instanceof AvailableState;
    }

    public void checkout(Member member) {
        currentState.checkout(this, member);
    }

    public void returnItem() {
        currentState.returnItem(this);
    }

    public void onHold(Member member) {
        currentState.placeHold(this, member);
    }

}
