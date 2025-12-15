package src.Library.Factory;

import src.Library.Entities.Book;
import src.Library.Entities.LibraryItem;
import src.Library.Entities.Magazine;
import src.Library.Enums.ItemType;

public class ItemFactory {
    public static LibraryItem createLibraryItem(ItemType type, String title, String authorOrPublisher) {
        switch (type) {
            case BOOK :
                return new Book(title, authorOrPublisher);
            case MAGAZINE :
                return new Magazine(title, authorOrPublisher);
            default:
                throw new IllegalArgumentException("Unknown Library Item Type");
        }
    }
}
