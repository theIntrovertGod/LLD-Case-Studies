package src.libraryManagementSystem.state;

import src.libraryManagementSystem.models.BookCopy;
import src.libraryManagementSystem.models.Member;

public interface ItemState {
    void checkOut(BookCopy copy, Member member);
    void returnItem(BookCopy copy);
    void placeHold(BookCopy copy, Member member);
}
