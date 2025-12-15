package src.Library.Strategy;

import src.Library.Entities.LibraryItem;

import java.util.List;

public interface SearchStrategyInterface {
    List<LibraryItem> search(String text,List<LibraryItem> items);
}
