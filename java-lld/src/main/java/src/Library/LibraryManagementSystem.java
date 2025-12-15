package src.Library;

import src.Library.Entities.BookCopy;
import src.Library.Entities.LibraryItem;
import src.Library.Entities.Member;
import src.Library.Enums.ItemType;
import src.Library.Factory.ItemFactory;
import src.Library.Strategy.SearchStrategyInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManagementSystem {
    private static final LibraryManagementSystem INSTANCE = new LibraryManagementSystem();
    private  final Map<String, LibraryItem> catalog = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final Map<String, BookCopy> copies = new HashMap<>();

    private LibraryManagementSystem(){}

    public static LibraryManagementSystem getInstance() {
        return INSTANCE;
    }

    public Map<String, Member> getMember() {
        return members;
    }

    public Map<String, LibraryItem> getCatalog() {
        return catalog;
    }

    public Map<String, BookCopy> getCopies() {
        return copies;
    }

    //    == Catalog Management
    public void addItem(ItemType type, String title, String name, String author, int numCopies) {
        LibraryItem item = ItemFactory.createLibraryItem(type, title, author);
        catalog.put(item.getId(), item);
        for (int i =0; i<numCopies; i++) {
            copies.put(item.getId(), new BookCopy(item));
        }
    }

//            User Management
    public Member addMember(String name) {
        Member member = new Member(name);
        members.put(member.getId(), member);
        return member;
    }

//    Checkout Management
    public void checkout(String memberId, String copyId){
        Member member = members.get(memberId);
        BookCopy copy = copies.get(copyId);
        copy.checkout(member);
    }

    public void returnItem(String copyId){
        BookCopy copy = copies.get(copyId);
        copy.returnItem();
    }

    public void holdCopy(String itemId, String mmeberId){
//        BookCopy copy = copies.get(copyId);
        Member member = members.get(mmeberId);
        LibraryItem item = catalog.get(itemId);

        item.getCopies().stream()
                .filter(c -> c.isAvailable())
                .findFirst()
                .ifPresent(copy -> copy.onHold(member));
    }

    //Search Management

    public List<LibraryItem> search(String query, SearchStrategyInterface strategy) {
        return strategy.search(query, new ArrayList<>(catalog.values()));
    }
}
