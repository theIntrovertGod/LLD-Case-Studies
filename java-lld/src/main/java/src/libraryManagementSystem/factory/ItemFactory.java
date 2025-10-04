package src.libraryManagementSystem.factory;

import src.libraryManagementSystem.enums.ItemType;
import src.libraryManagementSystem.models.Book;
import src.libraryManagementSystem.models.LibraryItem;
import src.libraryManagementSystem.models.Magazine;

public class ItemFactory {
    public static LibraryItem createItem(ItemType type, String id, String title, String author) {
        switch (type) {
            case BOOK: return new Book(id, title, author);
            case MAGAZINE: return new Magazine(id, title, author);
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }
}

//ItemFactory.createItem()