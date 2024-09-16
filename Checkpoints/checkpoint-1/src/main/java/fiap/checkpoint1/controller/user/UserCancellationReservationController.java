package fiap.checkpoint1.controller.user;


import fiap.checkpoint1.model.User;
import fiap.checkpoint1.service.library.LibraryManager;
import fiap.checkpoint1.service.user.UserManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserCancellationReservationController {

    private LibraryManager libraryManager;

    private UserManager userManager;

    public UserCancellationReservationController(LibraryManager libraryManager, UserManager userManager) {
        this.libraryManager = libraryManager;
        this.userManager = userManager;
    }

    @DeleteMapping("/{id}/reservation/{bookTitle}")
    public ResponseEntity<Void> cancelReservation(@PathVariable("id") long userId, @PathVariable("bookTitle") String bookTitle){
        User user = userManager.findUserById(userId);
        libraryManager.cancelReservation(bookTitle, user);
        return ResponseEntity.noContent().build();
    }
}
