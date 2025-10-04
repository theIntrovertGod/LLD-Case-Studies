package src.libraryManagementSystem.strategy;

import src.libraryManagementSystem.models.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class SearchByAuthorStrategy implements SearchStrategy{
    @Override
    public List<LibraryItem> search(String query, List<LibraryItem> libraryItems) {
        List<LibraryItem> result = new ArrayList<>();
        libraryItems.stream()
                .filter(item -> item.getAuthorOrPublisher().toLowerCase().contains(query.toLowerCase()))
                .forEach(result::add);
        return result;
    }
}
