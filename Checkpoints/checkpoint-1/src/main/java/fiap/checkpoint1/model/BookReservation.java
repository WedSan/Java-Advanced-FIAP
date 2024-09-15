package fiap.checkpoint1.model;

import java.time.LocalDateTime;

public class BookReservation {

    private User user;

    private Book book;

    private LocalDateTime reservationDate;

    public BookReservation(User user, Book book) {
        this.user = user;
        this.book = book;
        this.reservationDate = LocalDateTime.now();
    }

    public BookReservation(User user, Book book, LocalDateTime reservationDate) {
        this.user = user;
        this.book = book;
        this.reservationDate = reservationDate;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }
}
