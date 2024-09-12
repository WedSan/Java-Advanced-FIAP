package fiap.checkpoint1.service.bookSorter;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.service.BookSorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookTitleSorter implements BookSorter {
    public BookTitleSorter() {
    }

    @Override
    public List<Book> sortBooks(List<Book> books) {
        List<Book> booksOrdered = new ArrayList<>(books);
        booksOrdered.sort(Comparator.comparing(book -> book.getName()));
        return booksOrdered;
    }
}
