package src.Library.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Loan {
    private final String loanId;
    private final BookCopy copy;
    private final Member member;
    private final LocalDateTime checkedOutDate;

    public Loan(BookCopy copy, Member member) {
        this.loanId = UUID.randomUUID().toString();
        this.copy = copy;
        this.member = member;
        this.checkedOutDate = LocalDateTime.now();
    }

    public String getLoanId(){
        return loanId;
    }


    public BookCopy getCopy() {
        return copy;
    }

    public Member getMember() {
        return member;
    }
}
