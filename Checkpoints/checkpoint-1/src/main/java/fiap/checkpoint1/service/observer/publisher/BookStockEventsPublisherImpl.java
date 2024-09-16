package fiap.checkpoint1.service.observer.publisher;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.service.observer.event.BookIncreasedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class BookStockEventsPublisherImpl implements BookStockEventsPublisher{
    private ApplicationEventPublisher eventPublisher;

    public BookStockEventsPublisherImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publishIncreasedStock(Book book, int quantity) {
        BookIncreasedEvent increasedEvent = new BookIncreasedEvent(this, book, quantity);
        eventPublisher.publishEvent(increasedEvent);
    }

}
