package fiap.checkpoint1.service.observer.publisher;

import fiap.checkpoint1.model.Book;

public interface BookStockEventsPublisher {
    void publishIncreasedStock(Book book, int quantity);
}
