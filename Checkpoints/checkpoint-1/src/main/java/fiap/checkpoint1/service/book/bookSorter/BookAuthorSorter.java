package fiap.checkpoint1.service.book.bookSorter;

import fiap.checkpoint1.model.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookAuthorSorter extends AbstractBookSorter {


    @Override
    public List<Book> sortBooks(List<Book> books) {
        List<Book> booksOrdered = new ArrayList<>(books);
        booksOrdered.sort(Comparator.comparing(book -> book.getName()));
        return booksOrdered;
    }

    @Override
    protected Comparator<Book> getComparator() {
        return Comparator.comparing(book -> book.getAuthor());
    }
}
