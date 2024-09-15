package fiap.checkpoint1.service.library.reservation;

import fiap.checkpoint1.model.BookReservation;

public class BookReservationResult {
    private BookReservation bookReservation;

    private String resultMessage;

    private boolean isWaitingList;

    public BookReservationResult(BookReservation bookReservation, String resultMessage, boolean isWaitingList) {
        this.bookReservation = bookReservation;
        this.resultMessage = resultMessage;
        this.isWaitingList = isWaitingList;
    }

    public BookReservation getBookReservation() {
        return bookReservation;
    }

    public void setBookReservation(BookReservation bookReservation) {
        this.bookReservation = bookReservation;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public boolean isWaitingList() {
        return isWaitingList;
    }

    public void setWaitingList(boolean waitingList) {
        isWaitingList = waitingList;
    }
}
