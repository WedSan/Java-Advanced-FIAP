package fiap.checkpoint1.service.book.bookManager;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.service.book.bookSorter.BookSortOption;

import java.util.List;

public interface BookManager {

    void addBook(Book book);

    List<Book> listBooks();

    List<Book> listBooks(BookSortOption bookSortOption);

    List<Book> listBooks(BookSortOption bookSortOption, String categoryFilter);

    Book findBookByIsbn(String isbn);

    Book findBookByName(String bookName);

    void deleteBook(Book book);

}
