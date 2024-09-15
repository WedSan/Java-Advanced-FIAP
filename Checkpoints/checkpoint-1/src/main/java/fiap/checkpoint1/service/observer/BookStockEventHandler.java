package fiap.checkpoint1.service.observer;

import fiap.checkpoint1.service.observer.event.BookCreatedEvent;
import fiap.checkpoint1.service.observer.event.BookDeletedEvent;

public interface BookStockEventHandler {

    void handleBookAdded(BookCreatedEvent event);

    void handleDeleteBook(BookDeletedEvent event);

}
