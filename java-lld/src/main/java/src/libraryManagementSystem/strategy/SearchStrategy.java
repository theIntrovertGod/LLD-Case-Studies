package src.libraryManagementSystem.strategy;

import src.libraryManagementSystem.models.LibraryItem;

import java.util.List;

public interface SearchStrategy {
    List<LibraryItem> search(String query, List<LibraryItem> libraryItems);
}
