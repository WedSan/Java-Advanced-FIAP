package fiap.checkpoint1.service;

import fiap.checkpoint1.model.Book;

import java.util.List;

public interface BookManager {

    void addBook(Book book);

    List<Book> listBooks();

    List<Book> listBooks(BookSortOption bookSortOption);

    Book findBookByIsbn(String isbn);

    void findBookByName(String bookName);

    void deleteBook(Book book);

}
