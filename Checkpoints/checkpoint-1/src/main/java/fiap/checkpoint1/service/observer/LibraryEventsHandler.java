package fiap.checkpoint1.service.observer;

import fiap.checkpoint1.service.observer.event.BookCreatedEvent;
import fiap.checkpoint1.service.observer.event.BookDeleteEvent;
import fiap.checkpoint1.service.observer.event.BookDeletedEvent;
import fiap.checkpoint1.service.observer.event.BookIncreasedEvent;

public interface LibraryEventsHandler {


    void handleBookAdded(BookCreatedEvent event);

    void handleBookDelete(BookDeleteEvent event);

    void handleBookDeleted(BookDeletedEvent event);

    void handleBookIncreased(BookIncreasedEvent event);
}
