package fiap.checkpoint1.service.bookSorter;

import fiap.checkpoint1.model.Book;

import java.util.Comparator;

public class BookCategorySorter extends AbstractBookSorter{

    public BookCategorySorter() {
    }

    @Override
    protected Comparator<Book> getComparator() {
        return Comparator.comparing(book -> book.getCategory());
    }
}
