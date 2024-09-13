package fiap.checkpoint1.service;

import fiap.checkpoint1.factory.BookSorterFactory;
import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.model.exception.BookNotFoundException;
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

    private BookSorterFactory bookSorterFactory;


    public BookManagerImpl(BookCreationValidator bookCreationValidator,
                           BookListValidator bookListValidator, BookSorterFactory bookSorterFactory) {
        this.bookSorterFactory = bookSorterFactory;
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
        BookSorter bookSorter = bookSorterFactory.createBookSorter(bookSortOption);
        return bookSorter.sortBooks(books);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findAny()
                .orElseThrow(() -> new BookNotFoundException("Book with isbn " + isbn + " was not found"));
    }

    @Override
    public Book findBookByName(String bookName) {
        return books.stream()
                .filter(book -> book.getName().equals(bookName))
                .findAny()
                .orElseThrow(() -> new BookNotFoundException("The book " + bookName + " was not found"));
    }

    @Override
    public void deleteBook(Book book) {
        return;
    }
}
