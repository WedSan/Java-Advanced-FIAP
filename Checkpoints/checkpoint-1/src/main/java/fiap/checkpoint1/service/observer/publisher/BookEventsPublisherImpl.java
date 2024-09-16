package fiap.checkpoint1.service.observer.publisher;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.service.observer.event.BookCreatedEvent;
import fiap.checkpoint1.service.observer.event.BookDeleteEvent;
import fiap.checkpoint1.service.observer.event.BookDeletedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class BookEventsPublisherImpl implements BookEventsPublisher{

    private final ApplicationEventPublisher eventPublisher;

    public BookEventsPublisherImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishBookCreatedEvent(Book book){
        BookCreatedEvent event = new BookCreatedEvent(this, book);
        eventPublisher.publishEvent(event);
    }

    public void publishBookDeleteEvent(Book book){
        BookDeleteEvent event = new BookDeleteEvent(this, book);
        eventPublisher.publishEvent(event);
    }

    public void publishBookDeletedEvent(Book book){
        BookDeletedEvent event = new BookDeletedEvent(this, book);
        eventPublisher.publishEvent(event);
    }
}
