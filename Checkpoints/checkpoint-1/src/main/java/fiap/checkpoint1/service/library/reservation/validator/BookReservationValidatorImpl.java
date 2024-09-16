package fiap.checkpoint1.service.library.reservation.validator;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.model.BookReservation;
import fiap.checkpoint1.model.User;
import fiap.checkpoint1.exception.ReservationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Queue;

@Component
public class BookReservationValidatorImpl implements BookReservationValidator {

    @Override
    public void validate(List<BookReservation> reservationList, Map<Book, Queue<BookReservation>> waitingList, String bookTitle, User user) {
        checkUserReservedBook(reservationList, user, bookTitle);
        checkUserInWaitingList(waitingList, user, bookTitle);
    }

    private void checkUserReservedBook(List<BookReservation> reservationList, User user, String bookTitle){
        boolean userReservedBookBefore = reservationList.stream()
                .anyMatch(reservation -> reservation.getUser().equals(user) && reservation.getBook().getName().equalsIgnoreCase(bookTitle));
        if(userReservedBookBefore)
            throw new ReservationException("User "+ user.getName() +" already reserved the book " + bookTitle);
    }

    private void checkUserInWaitingList(Map<Book, Queue<BookReservation>> waitingList, User user, String bookTitle){
        boolean userExistsInWaitingList = waitingList.values()
                .stream()
                .flatMap(queue -> queue.stream())
                .anyMatch(bookReservation -> bookReservation.getUser().equals(user) && bookReservation.getBook().getName().equalsIgnoreCase(bookTitle));

        if(userExistsInWaitingList)
            throw new ReservationException("User "+ user.getName() +" is already in the waiting list for the book " + bookTitle);
    }

}
