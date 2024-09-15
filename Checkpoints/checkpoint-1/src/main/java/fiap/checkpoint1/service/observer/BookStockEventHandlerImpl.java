package fiap.checkpoint1.service.observer;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.service.bookStock.BookStock;
import fiap.checkpoint1.service.observer.event.BookCreatedEvent;
import fiap.checkpoint1.service.observer.event.BookDeletedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BookStockEventHandlerImpl implements BookStockEventHandler{

    private BookStock bookStock;

    public BookStockEventHandlerImpl(BookStock bookStock) {
        this.bookStock = bookStock;
    }

    @EventListener
    @Override
    public void handleBookAdded(BookCreatedEvent event) {
        Book bookAdded = event.getBook();
        Map<Book, Integer> stock = bookStock.getBookStock();
        if(stock.get(bookAdded) != null){
            bookStock.increaseStock(bookAdded, stock.get(bookAdded) + 1);
        }
        else{
            stock.put(bookAdded, 1);
        }
    }

    @EventListener
    @Override
    public void handleDeleteBook(BookDeletedEvent event) {
        Book bookDeleted = event.getBookDeleted();
        Map<Book, Integer> stock = bookStock.getBookStock();
        stock.remove(bookDeleted);
    }
}
