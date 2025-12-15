package src.Library.states;

import src.Library.Entities.BookCopy;
import src.Library.Entities.Member;
import src.Library.Service.TransactionService;

public class OnHoldState implements ItemState{
    @Override
    public void checkout(BookCopy copy, Member member) {
        if (copy.getItem().isObserver(member)) {
            TransactionService.getInstance().createLoan(copy,member);
            copy.getItem().removeObserver(member);
            copy.setState(new CheckedOutState());
            System.out.println("Hold fulfilled by  : " + member.getNAme());
        }else {
            System.out.println("Book cannot be checkout by the memmber requesitng this book.."  + member.getNAme());
        }
    }

    @Override
    public void returnItem(BookCopy copy) {
        System.out.println(("invalid Operation"));
    }

    @Override
    public void placeHold(BookCopy copy, Member member) {
        System.out.println("item is already  on hold, ");
    }
}
