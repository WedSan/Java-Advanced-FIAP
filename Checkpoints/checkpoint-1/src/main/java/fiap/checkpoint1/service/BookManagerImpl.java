package fiap.checkpoint1.service;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.service.validator.BookCreationValidator;
import fiap.checkpoint1.service.validator.BookListValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookManagerImpl implements BookManager{

    private List<Book> books;

    private BookCreationValidator bookCreationValidator;

    private BookListValidator bookListValidator;

    public BookManagerImpl(BookCreationValidator bookCreationValidator,
                           BookListValidator bookListValidator) {
        this.books = new ArrayList<>();
        this.bookCreationValidator = bookCreationValidator;
        this.bookListValidator = bookListValidator;
    }

    @Override
    public void addBook(Book book) {
        bookCreationValidator.validate(book);
        bookListValidator.validate(books, book);

        books.add(book);
    }

    @Override
    public List<Book> listBooks() {
        return books;
    }

    @Override
    public List<Book> listBooks(BookSortOption bookSortOption) {
        return List.of();
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return null;
    }

    @Override
    public void findBookByName(String bookName) {
        return;
    }

    @Override
    public void deleteBook(Book book) {
        return;
    }
}
