package fiap.checkpoint1.service.library;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.model.BookReservation;
import fiap.checkpoint1.model.User;
import fiap.checkpoint1.exception.ReservationNotFoundException;
import fiap.checkpoint1.exception.WaitingListNotFoundException;
import fiap.checkpoint1.service.book.bookManager.BookManager;
import fiap.checkpoint1.service.library.reservation.BookReservationResult;
import fiap.checkpoint1.service.library.reservation.validator.BookReservationValidator;
import fiap.checkpoint1.service.bookStock.BookStock;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class LibraryManagerImpl implements LibraryManager {

    private BookManager bookManager;

    private BookStock bookStock;

    private List<BookReservation> bookReservations;

    private Map<Book, Queue<BookReservation>> bookWaitingList;

    private BookReservationValidator bookReservationValidator;

    public LibraryManagerImpl(BookManager bookManager, BookStock bookStock, BookReservationValidator bookReservationValidator) {
        this.bookManager = bookManager;
        this.bookStock = bookStock;
        this.bookReservationValidator = bookReservationValidator;
        this.bookReservations = new ArrayList<>();
        this.bookWaitingList = new HashMap<>();
    }

    @Override
    public BookReservationResult reserveBook(String bookTitle, User user) {
        Book reservedBook = bookManager.findBookByName(bookTitle);
        bookReservationValidator.validate(bookReservations, bookWaitingList, bookTitle, user);
        BookReservation bookReservation = new BookReservation(user, reservedBook);

        if(bookStock.countBooks(reservedBook) > 0) {
            bookReservations.add(bookReservation);
            bookStock.reduceStock(reservedBook, 1);
            return new BookReservationResult(bookReservation, "Reservation successful", false);
        }

        bookWaitingList.get(reservedBook).add(bookReservation);
        return new BookReservationResult(bookReservation, "Book is not available, you are now in the waiting list", true);
    }

    public void transferFromWaitingListToReservation(String bookTitle, int quantity){
        Book bookFounded = bookManager.findBookByName(bookTitle);
        for(int i = 0; i < quantity; i++){
            if(bookStock.countBooks(bookFounded) > 0){
                BookReservation reservationToTransfer = bookWaitingList.get(bookFounded).poll();
                if(reservationToTransfer == null)
                    break;
                bookReservations.add(reservationToTransfer);
                bookStock.reduceStock(bookFounded, 1);
            }
        }
    }

    @Override
    public void cancelReservation(String bookTitle, User user) {
        Book foundBook = bookManager.findBookByName(bookTitle);
        BookReservation reservationToDelete = bookReservations.stream()
                .filter(reservation -> reservation.getUser().equals(user) && reservation.getBook().equals(foundBook))
                .findFirst()
                .orElseThrow(()-> new ReservationNotFoundException("Reservation not found"));

        bookReservations.remove(reservationToDelete);
        bookStock.increaseStock(foundBook, 1);
    }

    @Override
    public void cancelWaitingList(String bookTitle, User user) {
        Book reservedBook = bookManager.findBookByName(bookTitle);
        if(!bookWaitingList.containsKey(reservedBook))
            throw new WaitingListNotFoundException("Waiting list not found");

        Queue<BookReservation> bookReservationQueue = bookWaitingList.get(reservedBook);
        boolean userRemoved = bookReservationQueue.removeIf(bookReservation -> bookReservation.getUser().equals(user));

        if(!userRemoved)
            throw new WaitingListNotFoundException("User not found in waiting list");
    }

    @Override
    public List<BookReservation> getAllReservations() {
        return bookReservations;
    }

    @Override
    public List<BookReservation> getAllReservations(User user) {
        return bookReservations.stream()
                .filter(reservation -> reservation.getUser().equals(user))
                .toList();
    }

    @Override
    public Map<Book, Queue<BookReservation>> getAllWaitingList() {
        return bookWaitingList;
    }

    @Override
    public List<BookReservation> getAllWaitingList(User user) {
        return bookWaitingList.values()
                .stream()
                .flatMap(queue -> queue.stream())
                .filter(bookReservation -> bookReservation.getUser().equals(user))
                .toList();
    }

    @Override
    public List<BookReservation> getAllWaitingList(String bookTitle) {
        Book book = bookManager.findBookByName(bookTitle);
        return bookWaitingList.values()
                .stream()
                .flatMap(queue -> queue.stream())
                .filter(bookReservation -> bookReservation.getBook().equals(book))
                .toList();
    }

}
