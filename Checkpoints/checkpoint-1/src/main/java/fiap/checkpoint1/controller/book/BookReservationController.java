package fiap.checkpoint1.controller.book;

import fiap.checkpoint1.dto.request.BookReservationRequestDTO;
import fiap.checkpoint1.dto.response.BookReservationResultResponseDTO;
import fiap.checkpoint1.dto.response.ReservationResponseDTO;
import fiap.checkpoint1.mapper.BookReservationMapper;
import fiap.checkpoint1.model.BookReservation;
import fiap.checkpoint1.model.User;
import fiap.checkpoint1.service.library.reservation.BookReservationResult;
import fiap.checkpoint1.service.library.LibraryManager;
import fiap.checkpoint1.service.library.reservation.ReservationQueryFinder;
import fiap.checkpoint1.service.user.UserManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book/reservation")
public class BookReservationController {

    private LibraryManager libraryManager;

    private UserManager userManager;

    private ReservationQueryFinder reservationQueryFinder;


    public BookReservationController(LibraryManager libraryManager, UserManager userManager, ReservationQueryFinder reservationQueryFinder) {
        this.libraryManager = libraryManager;
        this.userManager = userManager;
        this.reservationQueryFinder = reservationQueryFinder;
    }

    @PostMapping
    public ResponseEntity<BookReservationResultResponseDTO> reserveBook(@RequestBody BookReservationRequestDTO request){
        User userFounded = userManager.findUserById(request.userId());
        BookReservationResult reservationResult = libraryManager.reserveBook(request.bookTitle(), userFounded);
        HttpStatus httpStatus = reservationResult.isWaitingList() ? HttpStatus.ACCEPTED : HttpStatus.OK;
        return ResponseEntity.status(httpStatus).body(BookReservationMapper.toDTO(reservationResult));
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponseDTO>> getAllReservations(@RequestParam(name = "user_id",
            required = false) Long userId){
        List<BookReservation> reservations = reservationQueryFinder.getReservations(userId);
        return ResponseEntity.status(HttpStatus.OK).body(BookReservationMapper.toDTO(reservations));
    }

    @DeleteMapping
    public ResponseEntity<Void> cancelReservation(@RequestParam(name = "book_title") String bookTitle,
                                                 @RequestParam(name = "user_id") Long userId){
        User userFounded = userManager.findUserById(userId);
        libraryManager.cancelReservation(bookTitle, userFounded);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
