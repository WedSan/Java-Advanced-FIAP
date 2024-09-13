package fiap.checkpoint1.service.bookSorter;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.service.BookSorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractBookSorter implements BookSorter {
    @Override
    public List<Book> sortBooks(List<Book> books) {
        List<Book> booksOrdered = new ArrayList<>(books);
        booksOrdered.sort(getComparator());
        return booksOrdered;
    }

    protected abstract Comparator<Book> getComparator();
}
