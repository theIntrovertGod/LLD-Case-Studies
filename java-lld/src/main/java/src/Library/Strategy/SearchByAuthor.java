package src.Library.Strategy;

import src.Library.Entities.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class SearchByAuthor implements SearchStrategyInterface {
    @Override
    public List<LibraryItem> search(String text, List<LibraryItem> items) {
        List<LibraryItem> result = new ArrayList<LibraryItem>();
        items.stream()
                .filter(item -> item.getAuthorOrPublisher().toLowerCase().equals(text))
                .forEach(result::add);
        return result;
    }
}
