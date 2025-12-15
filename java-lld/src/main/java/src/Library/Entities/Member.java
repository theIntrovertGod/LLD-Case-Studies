package src.Library.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class Member {
    public static final Integer MAX_LOANS = 5;
    private final String id;
    private final String name;
    private final List<Loan> loans = new ArrayList<>();

    public Member(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getNAme() {
        return name;
    }

    public String getId() {
        return id;
    }
    public void addLoan(Loan loan) {
        if (loans.size() >= MAX_LOANS) {
            System.out.println("User exceeded maximum loan capacity");
            return;
        }
        loans.add(loan);
    }
    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    // OBSERVER Update Method::
    public void update(LibraryItem item) {
        System.out.println("Notification for : " + item.getTitle() + " is available now.");
    }
}


