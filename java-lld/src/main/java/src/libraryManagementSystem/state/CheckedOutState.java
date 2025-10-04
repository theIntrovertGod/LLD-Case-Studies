package src.libraryManagementSystem.state;

import src.libraryManagementSystem.TransactionService;
import src.libraryManagementSystem.models.BookCopy;
import src.libraryManagementSystem.models.Member;

public class CheckedOutState implements ItemState{
    @Override
    public void checkOut(BookCopy copy, Member member) {
        System.out.println("it is alredy checked out.");
    }

    @Override
    public void returnItem(BookCopy copy) {
        TransactionService.getInstance().endLoan(copy);
        System.out.println(copy.getId() + "is returned.");
        if(copy.getItem().hasObservers()){
            copy.setState(new OnHoldState());
            copy.getItem().notifyObservers();
        }else{
            copy.setState(new AvailableState());
        }
    }

    @Override
    public void placeHold(BookCopy copy, Member member) {
        copy.getItem().addObserver(member);
        System.out.println(member.getName() + "placed a hold on " + copy.getItem().getTitle());
    }
}
