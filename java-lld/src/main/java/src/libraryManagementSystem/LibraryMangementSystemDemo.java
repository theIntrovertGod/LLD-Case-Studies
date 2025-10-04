package src.libraryManagementSystem;

import src.libraryManagementSystem.enums.ItemType;
import src.libraryManagementSystem.models.BookCopy;
import src.libraryManagementSystem.models.Member;
import src.libraryManagementSystem.strategy.SearchByTitleStrategy;

import java.util.List;

public class LibraryMangementSystemDemo {
    public static void main(String[] args) {
        LibraryManagementSystem library = LibraryManagementSystem.getInstance();

        List<BookCopy> hobbitCopies = library.addItem(ItemType.BOOK, "B001", "The Hobbit", "J.R.R. Tolkien", 2);
        List<BookCopy> duneCopies = library.addItem(ItemType.BOOK, "B002", "Dune", "Frank Herbert", 1);
        List<BookCopy> natGeoCopies = library.addItem(ItemType.MAGAZINE, "M001", "National Geographic", "NatGeo Society", 3);

        Member alice = library.addMember("MEM01", "Alice");
        Member bob = library.addMember("MEM02", "Bob");
        Member charlie = library.addMember("MEM03", "Charlie");

        library.search("Hob", new SearchByTitleStrategy()).forEach((item -> System.out.println(("Found : " + item.getTitle()))));
    }
}


