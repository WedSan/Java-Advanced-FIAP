package fiap.checkpoint1.model;

import java.time.LocalDateTime;

public class BookReservation {

    private static long idCounter = 0;

    private long id;

    private User user;

    private Book book;

    private LocalDateTime reservationDate;

    public BookReservation(User user, Book book) {
        this.id = ++idCounter;
        this.user = user;
        this.book = book;
        this.reservationDate = LocalDateTime.now();
    }

    public BookReservation(User user, Book book, LocalDateTime reservationDate) {
        this.user = user;
        this.book = book;
        this.reservationDate = reservationDate;
    }

    public long getId() {
        return id;
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

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }
}
