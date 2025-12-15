package src.Library.states;

import src.Library.Entities.BookCopy;
import src.Library.Entities.Member;
import src.Library.Service.TransactionService;

public class CheckedOutState implements ItemState {
    @Override
    public void checkout(BookCopy copy, Member member) {
        System.out.println("Cannot chekcout an already checked out book");
    }

    @Override
    public void returnItem(BookCopy copy) {
        TransactionService.getInstance().endLoad(copy);
        copy.setState(new AvailableState());
        copy.getItem().notifyObservers();
    }

    @Override
    public void placeHold(BookCopy copy, Member member) {
        copy.getItem().addObserver(member);
        System.out.println("Place hold by observer " + member.getNAme());
    }
}
