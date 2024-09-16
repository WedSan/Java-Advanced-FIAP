package fiap.checkpoint1.service.observer.event;

import fiap.checkpoint1.model.Book;
import org.springframework.context.ApplicationEvent;

public class BookDeletedEvent extends ApplicationEvent {
    private final Book bookDeleted;

    public BookDeletedEvent(Object source, Book bookDeleted) {
        super(source);
        this.bookDeleted = bookDeleted;
    }

    public Book getBookDeleted() {
        return bookDeleted;
    }
}
