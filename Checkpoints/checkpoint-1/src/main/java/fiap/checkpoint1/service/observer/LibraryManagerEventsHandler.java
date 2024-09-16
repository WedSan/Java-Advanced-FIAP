package fiap.checkpoint1.service.observer;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.model.BookReservation;
import fiap.checkpoint1.exception.CancellationReservationException;
import fiap.checkpoint1.service.library.LibraryManager;
import fiap.checkpoint1.service.observer.event.BookCreatedEvent;
import fiap.checkpoint1.service.observer.event.BookDeleteEvent;
import fiap.checkpoint1.service.observer.event.BookDeletedEvent;
import fiap.checkpoint1.service.observer.event.BookIncreasedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@Component
public class LibraryManagerEventsHandler implements LibraryEventsHandler {

    private LibraryManager libraryManager;

    public LibraryManagerEventsHandler(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @EventListener
    public void handleBookAdded(BookCreatedEvent event){
        Book eventBook = event.getBook();
        Queue<BookReservation> waitingListQueue = libraryManager.getAllWaitingList().get(eventBook);

        if(waitingListQueue == null){
            libraryManager.getAllWaitingList().put(eventBook, new LinkedList<>());
        }
    }

    @EventListener
    public void handleBookIncreased(BookIncreasedEvent event){
        libraryManager.transferFromWaitingListToReservation(event.getBook().getName(), event.getQuantityIncreased());
    }

    @EventListener
    public void handleBookDelete(BookDeleteEvent event){
        verifyBookIsBeingUsed(event);
    }

    @EventListener
    public void handleBookDeleted(BookDeletedEvent event){
        removeBookFromWaitingList(event);
    }

    private void verifyBookIsBeingUsed(BookDeleteEvent event){
        Book eventBook = event.getBook();
        Queue<BookReservation> waitingList = libraryManager.getAllWaitingList().get(eventBook);
        if(waitingList == null)
            return;

        boolean someoneHasBook = libraryManager.getAllReservations().stream()
                .anyMatch(bookReservation -> bookReservation.getBook().equals(eventBook));

        if(!waitingList.isEmpty() || someoneHasBook)
            throw new CancellationReservationException("Book has reservations or someone has the book and didn't return it");
    }

    private void removeBookFromWaitingList(BookDeletedEvent event){
        Map<Book, Queue<BookReservation>> waitingList = libraryManager.getAllWaitingList();
        waitingList.remove(event.getBookDeleted());
    }
}
