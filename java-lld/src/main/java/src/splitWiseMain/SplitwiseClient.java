package src.splitWiseMain;

import src.splitWiseMain.SplitStrategy.EqualSplitStrategy;
import src.splitWiseMain.entities.Expense;
import src.splitWiseMain.entities.Group;
import src.splitWiseMain.entities.User;
import src.splitWiseMain.service.SplitwiseService;

import java.util.Arrays;
import java.util.List;

public class SplitwiseClient {
    public static void main(String[] args) {
        SplitwiseService service = SplitwiseService.getInstance();

        User Kartik = service.addUser("Kartik", "Kartik@utdallas.edu");
        User Arnav = service.addUser("Arnav", "Arnav@utdallas.edu");
        User Amey = service.addUser("Amey", "Amey@utdallas.edu");
        User Srajit = service.addUser("Srajit", "Srajit@utdallas.edu");

        Group northSide = service.addGroup("Building 13", List.of(Kartik, Arnav, Amey, Srajit));

        service.createExpense(new Expense.ExpenseBuilder()
                .setDescription("Bindass")
                .setAmount(12000)
                .setPaidBy(Arnav)
                .setParticipants(Arrays.asList(Arnav, Srajit, Amey, Kartik))
                .setSplitStrategy(new EqualSplitStrategy())
        );

        service.showBalanceSheet(Arnav.getId());

    }
}
