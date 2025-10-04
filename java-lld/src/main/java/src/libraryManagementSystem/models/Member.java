package src.libraryManagementSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String id;
    private final String name;

    private  final List<Loan> loans = new ArrayList<>();

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    //Observer Update Method
    public void update(LibraryItem item){
        System.out.println("Notification for  : " +  name + item.getTitle() + " you placed a hold is now available");
    }

    public void addLoan(Loan loan){
        loans.add(loan);
    }

    public void removeLoan(Loan loan){
        loans.remove(loan);
    }
    public List<Loan> getLoans() {
        return loans;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
