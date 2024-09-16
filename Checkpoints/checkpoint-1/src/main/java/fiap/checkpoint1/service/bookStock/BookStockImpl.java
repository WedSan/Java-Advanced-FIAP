package fiap.checkpoint1.service.bookStock;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.exception.BookStockException;
import fiap.checkpoint1.exception.StockQuantityException;
import fiap.checkpoint1.service.observer.publisher.BookStockEventsPublisher;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookStockImpl implements BookStock{

    private Map<Book, Integer> bookStock;

    private BookStockEventsPublisher publisher;

    public BookStockImpl(BookStockEventsPublisher publisher) {
        this.publisher = publisher;
        this.bookStock = new HashMap<>();
    }

    @Override
    public int countBooks(Book book) {
        return bookStock.get(book);
    }

    @Override
    public void increaseStock(Book book, int quantity) {
        validateBookExists(book);
        bookStock.put(book, bookStock.get(book) + quantity);
        publisher.publishIncreasedStock(book, quantity);
    }

    @Override
    public void reduceStock(Book book, int quantity) {
        validateBookExists(book);
        if(bookStock.get(book) < quantity){
            throw new StockQuantityException("There are not enough books in stock");
        }
        bookStock.put(book, bookStock.get(book) - quantity);
    }

    private void validateBookExists(Book book){
        if(!bookStock.containsKey(book)){
            throw new BookStockException("The book " + book.getName() +" is not in stock");
        }
    }

    @Override
    public Map<Book, Integer> getBookStock() {
        return bookStock;
    }
}
