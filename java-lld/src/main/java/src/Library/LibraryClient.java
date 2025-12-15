package src.Library;

import src.Library.Entities.BookCopy;
import src.Library.Entities.LibraryItem;
import src.Library.Entities.Member;
import src.Library.Enums.ItemType;
import src.Library.Strategy.SearchByTitle;
import src.Library.Strategy.SearchByTitle;

import java.util.List;

public class LibraryClient {
    public static void main(String[] args) {
        LibraryManagementSystem library = LibraryManagementSystem.getInstance();

        library.addItem(ItemType.BOOK, "Coreman1", "Trump", "Ashish", 4);
        library.addItem(ItemType.BOOK, "OOPs", "Modi", "Copart", 3);
        library.addItem(ItemType.BOOK, "LifeIsMyth", "", "AI Team", 2);

        Member Praveen = library.addMember("Praveen");
        Member Krishna = library.addMember("Krishna");
        Member Jalal = library.addMember("Jalal");

        System.out.println(Praveen);
        System.out.println(Krishna);
        System.out.println(Jalal);

        System.out.println(library.getCatalog());
        System.out.println(library.getCopies());

        System.out.println(library.getMember());

        List<LibraryItem> coreManbooks = library.search("coreman1", new SearchByTitle());

        System.out.println(coreManbooks);

        library.checkout(Praveen.getId(), coreManbooks.get(0).getId());
        library.checkout(Krishna.getId(), coreManbooks.get(0).getId());



    }
}
