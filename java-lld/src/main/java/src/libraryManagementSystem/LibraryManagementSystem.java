package src.libraryManagementSystem;

import src.libraryManagementSystem.enums.ItemType;
import src.libraryManagementSystem.factory.ItemFactory;
import src.libraryManagementSystem.models.Book;
import src.libraryManagementSystem.models.BookCopy;
import src.libraryManagementSystem.models.LibraryItem;
import src.libraryManagementSystem.models.Member;
import src.libraryManagementSystem.strategy.SearchStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManagementSystem {
    private static final LibraryManagementSystem INSTANCE = new LibraryManagementSystem();

    private LibraryManagementSystem() {};
    public static LibraryManagementSystem getInstance() {
        return INSTANCE;
    }

    private final Map<String, Member> members = new HashMap<>();
    private final Map<String, LibraryItem> catalog = new HashMap<>();
    private final Map<String, BookCopy> copies = new HashMap<>();

    public List<BookCopy> addItem(ItemType type, String id, String title, String author, int numCopies) {
        List<BookCopy> bookCopies = new ArrayList<>();
        LibraryItem item = ItemFactory.createItem(type, id, title, author);
        catalog.put(id, item);
        for (int i = 0; i < numCopies; i++) {
            String copyId = id + "-c" + (i+1);
            BookCopy copy = new BookCopy(copyId, item);
            copies.put(copyId, copy);
            bookCopies.add(copy);
        }
        return bookCopies;
    }

    public Member addMember(String id,String name) {
        Member member = new Member(id, name);
        members.put(id, member);
        return member;
    }

    public void checkout(String memberId, String copyId) {
        Member member = members.get(memberId);
        BookCopy copy = copies.get(copyId);
        if (member != null && copy != null) {
            copy.checkout(member);
        }else {
            System.out.println("Invalid member or copy Id");
        }
    }

    public void returnItem(String copyId) {
        BookCopy copy = copies.get(copyId);
        if (copy != null) {
            copy.returnItem();
        }else {
            System.out.println("Invalid copy Id");
        }
    }

    public void placeHold(String memberId, String copyId) {
        Member member = members.get(memberId);
        LibraryItem item = catalog.get(copyId);
        if(member != null && item != null) {
            item.getCopies().stream().filter(c -> !c.isAvailable())
                    .findFirst()
                    .ifPresent(copy -> copy.placeHold(member));
        }
    }

    public List<LibraryItem> search(String query, SearchStrategy strategy) {
        return strategy.search(query, new ArrayList<>(catalog.values()));
    }
}
