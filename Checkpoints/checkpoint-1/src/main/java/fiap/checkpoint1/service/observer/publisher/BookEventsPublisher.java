package fiap.checkpoint1.service.observer.publisher;

import fiap.checkpoint1.model.Book;

public interface BookEventsPublisher {

    void publishBookCreatedEvent(Book book);

    void publishBookDeleteEvent(Book book);

    public void publishBookDeletedEvent(Book book);
}
