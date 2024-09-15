package fiap.checkpoint1.service.book.bookSorter;

import fiap.checkpoint1.model.Book;

import java.util.Comparator;


public class BookTitleSorter extends AbstractBookSorter implements BookSorter {
    public BookTitleSorter() {
    }

    @Override
    protected Comparator<Book> getComparator() {
        return Comparator.comparing(book -> book.getName());
    }

}
