package src.Library.Service;

import src.Library.Entities.BookCopy;
import src.Library.Entities.Loan;
import src.Library.Entities.Member;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionService {
    public static final TransactionService INSTANCE = new TransactionService();
    //String of Mao copyId
    private final Map<String, Loan> activeLoans = new ConcurrentHashMap<>();

    private TransactionService() {}
    public static TransactionService getInstance() {
        return INSTANCE;
    }

    public void createLoan(BookCopy copy, Member member) {
        Loan loan = new Loan(copy, member);
        activeLoans.put(copy.getId(), loan);
        member.addLoan(loan);
    }

    public void endLoad(BookCopy copy) {
        Loan loan = activeLoans.get(copy.getId());
        activeLoans.remove(copy.getId());
        if (loan != null) {
            loan.getMember().removeLoan(loan);
        }
    }
}
