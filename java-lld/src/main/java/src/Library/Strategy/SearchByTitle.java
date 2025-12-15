package src.Library.Strategy;

import src.Library.Entities.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class SearchByTitle implements SearchStrategyInterface {
    @Override
    public List<LibraryItem> search(String text, List<LibraryItem> items) {
        List<LibraryItem> result = new ArrayList<LibraryItem>();
        items.stream()
                .filter(item -> item.getTitle().toLowerCase().equals(text))
                .forEach(result::add);
        return result;
    }
}
