package fiap.checkpoint1.service.book.bookSorter;

import fiap.checkpoint1.model.Book;

import java.util.List;

public interface BookSorter {

    List<Book> sortBooks(List<Book> books);
}
