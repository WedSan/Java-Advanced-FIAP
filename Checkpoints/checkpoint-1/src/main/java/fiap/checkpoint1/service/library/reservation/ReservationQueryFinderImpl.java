package fiap.checkpoint1.service.library.reservation;

import fiap.checkpoint1.model.BookReservation;
import fiap.checkpoint1.model.User;
import fiap.checkpoint1.service.library.LibraryManager;
import fiap.checkpoint1.service.user.UserManager;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservationQueryFinderImpl implements ReservationQueryFinder {

    private LibraryManager libraryManager;

    private UserManager userManager;

    public ReservationQueryFinderImpl(LibraryManager libraryManager, UserManager userManager) {
        this.libraryManager = libraryManager;
        this.userManager = userManager;
    }

    @Override
    public List<BookReservation> getReservations(Long userId) {
        List<BookReservation> reservations;
        if(userId == null)
            reservations = libraryManager.getAllReservations();
        else{
            User user = userManager.findUserById(userId);
            reservations = libraryManager.getAllReservations(user);
        }
        return reservations;
    }
}
