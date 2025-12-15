package src.Library.states;

import src.Library.Entities.BookCopy;
import src.Library.Entities.Member;

public interface ItemState {
    void checkout(BookCopy copy, Member member);
    void returnItem(BookCopy copy);
    void placeHold(BookCopy copy, Member member);
}
