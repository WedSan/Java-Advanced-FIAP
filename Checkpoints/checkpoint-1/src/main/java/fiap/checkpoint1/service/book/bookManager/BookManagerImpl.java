package fiap.checkpoint1.service.book.bookManager;

import fiap.checkpoint1.factory.BookSorterFactory;
import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.exception.BookCategoryException;
import fiap.checkpoint1.exception.BookNotFoundException;
import fiap.checkpoint1.service.book.bookFilter.BookCategoryFilter;
import fiap.checkpoint1.service.book.bookManager.validator.BookListValidator;
import fiap.checkpoint1.service.book.bookSorter.BookSortOption;
import fiap.checkpoint1.service.book.bookSorter.BookSorter;
import fiap.checkpoint1.service.observer.publisher.BookEventsPublisher;
import fiap.checkpoint1.service.book.bookManager.validator.BookCreationValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookManagerImpl implements BookManager{

    private List<Book> books;

    private BookCreationValidator bookCreationValidator;

    private BookListValidator bookListValidator;

    private BookSorterFactory bookSorterFactory;

    private BookEventsPublisher bookEventsPublisher;

    private BookCategoryFilter bookCategoryFilter;


    public BookManagerImpl(BookCreationValidator bookCreationValidator,
                           BookListValidator bookListValidator, BookSorterFactory bookSorterFactory, BookEventsPublisher eventPublisher, BookCategoryFilter bookCategoryFilter) {
        this.bookEventsPublisher = eventPublisher;
        this.bookCategoryFilter = bookCategoryFilter;
        this.books = new ArrayList<>();
        this.bookSorterFactory = bookSorterFactory;
        this.bookCreationValidator = bookCreationValidator;
        this.bookListValidator = bookListValidator;
    }

    @Override
    public void addBook(Book book) {
        bookCreationValidator.validate(book);
        bookListValidator.validate(books, book);
        bookEventsPublisher.publishBookCreatedEvent(book);
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
    public List<Book> listBooks(BookSortOption bookSortOption, String categoryFilter) {
        BookSorter bookSorter = bookSorterFactory.createBookSorter(bookSortOption);
        List<Book> sortedBooks = books;
        if(categoryFilter != null){
            sortedBooks = bookCategoryFilter.filterByCategory(sortedBooks, categoryFilter);
            if(sortedBooks.isEmpty())
                throw new BookCategoryException("No books found in category " + categoryFilter);
        }
        return bookSorter.sortBooks(sortedBooks);
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
                .filter(book -> book.getName().equalsIgnoreCase(bookName))
                .findAny()
                .orElseThrow(() -> new BookNotFoundException("The book " + bookName + " was not found"));
    }


    @Override
    public void deleteBook(Book book) {
        Book bookRemoved = findBookByIsbn(book.getIsbn());
        bookEventsPublisher.publishBookDeleteEvent(book);
        books.remove(bookRemoved);
        bookEventsPublisher.publishBookDeletedEvent(book);
    }
}
