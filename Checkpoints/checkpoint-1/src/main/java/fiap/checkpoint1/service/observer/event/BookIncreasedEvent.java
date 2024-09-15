package fiap.checkpoint1.service.observer.event;

import fiap.checkpoint1.model.Book;
import org.springframework.context.ApplicationEvent;

public class BookIncreasedEvent extends ApplicationEvent {
    private final Book book;

    private final int quantityIncreased;

    public BookIncreasedEvent(Object source, Book book, int quantityIncreased) {
        super(source);
        this.book = book;
        this.quantityIncreased = quantityIncreased;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantityIncreased() {
        return quantityIncreased;
    }
}
