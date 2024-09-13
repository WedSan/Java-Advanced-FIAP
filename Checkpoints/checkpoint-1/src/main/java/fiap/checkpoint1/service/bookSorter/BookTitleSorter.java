package fiap.checkpoint1.service.bookSorter;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.service.BookSorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class BookTitleSorter extends AbstractBookSorter implements BookSorter {
    public BookTitleSorter() {
    }

    @Override
    protected Comparator<Book> getComparator() {
        return Comparator.comparing(book -> book.getName());
    }

}
