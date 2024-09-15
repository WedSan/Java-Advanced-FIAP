package fiap.checkpoint1.service;

import fiap.checkpoint1.factory.BookSorterFactory;
import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.model.exception.BookNotFoundException;
import fiap.checkpoint1.service.validator.BookCreationValidator;
import fiap.checkpoint1.service.validator.BookListValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookManagerImpl implements BookManager{

    private Map<Book, Integer> bookStock;

    private List<Book> books;

    private BookCreationValidator bookCreationValidator;

    private BookListValidator bookListValidator;

    private BookSorterFactory bookSorterFactory;


    public BookManagerImpl(BookCreationValidator bookCreationValidator,
                           BookListValidator bookListValidator, BookSorterFactory bookSorterFactory) {
        this.bookStock = new HashMap<>();
        this.books = new ArrayList<>();
        this.bookSorterFactory = bookSorterFactory;
        this.bookCreationValidator = bookCreationValidator;
        this.bookListValidator = bookListValidator;
    }

    @Override
    public void addBook(Book book) {
        bookCreationValidator.validate(book);

        if(books.contains(book)){
            bookStock.put(book, bookStock.get(book) + 1);
        }
        else{
            books.add(book);
            bookStock.put(book, 1);
        }
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
        return qwerrqwrqerqewrqwerwq;
    }
}
