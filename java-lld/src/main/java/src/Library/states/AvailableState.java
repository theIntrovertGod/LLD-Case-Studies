package src.Library.states;

import src.Library.Entities.BookCopy;
import src.Library.Entities.Member;
import src.Library.Service.TransactionService;
import src.Library.states.CheckedOutState;

public class AvailableState implements ItemState{
    @Override
    public void checkout(BookCopy copy, Member member) {
        TransactionService.getInstance().createLoan(copy, member);
        copy.setState(new CheckedOutState());
        System.out.println(copy.getId() + "checked out book");
    }

    @Override
    public void returnItem(BookCopy copy) {
        System.out.println(" Cannot return an Avaialble item");
    }

    @Override
    public void placeHold(BookCopy copy, Member member) {
        System.out.println("Caanot place hold on availabel item");
    }
}
