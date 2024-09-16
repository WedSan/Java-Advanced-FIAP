package fiap.checkpoint1.service.observer.event;

import fiap.checkpoint1.model.Book;
import org.springframework.context.ApplicationEvent;

public class BookCreatedEvent extends ApplicationEvent {

    private final Book book;

    public BookCreatedEvent(Object source, Book book) {
        super(source);
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
