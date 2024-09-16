package fiap.checkpoint1.controller.user;

import fiap.checkpoint1.dto.response.ReservationResponseDTO;
import fiap.checkpoint1.mapper.BookReservationMapper;
import fiap.checkpoint1.model.BookReservation;
import fiap.checkpoint1.model.User;
import fiap.checkpoint1.service.library.LibraryManager;
import fiap.checkpoint1.service.user.UserManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserWaitingListController {

    private LibraryManager libraryManager;

    private UserManager userManager;

    public UserWaitingListController(LibraryManager libraryManager, UserManager userManager) {
        this.libraryManager = libraryManager;
        this.userManager = userManager;
    }

    @GetMapping("/{userId}/waiting_list")
    public ResponseEntity<List<ReservationResponseDTO>> getUserWaitingList(@PathVariable("userId") long userId){
        User userFounded = userManager.findUserById(userId);
        List<BookReservation> waitingList = libraryManager.getAllWaitingList(userFounded);
        return ResponseEntity.status(HttpStatus.OK).body(BookReservationMapper.toDTO(waitingList));
    }

    @DeleteMapping("/{userId}/waiting_list/{bookTitle}")
    public ResponseEntity<Void> removeWaitingList(@PathVariable("userId") long userId, @PathVariable("bookTitle") String bookTitle){
        User userFounded = userManager.findUserById(userId);
        libraryManager.cancelWaitingList(bookTitle, userFounded);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
